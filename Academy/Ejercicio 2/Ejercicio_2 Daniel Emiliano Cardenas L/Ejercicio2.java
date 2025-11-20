import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Ejercicio2 extends JFrame {

    private JTextField accountField;
    private JLabel statusLabel;
    private JLabel countLabel;
    private static final int ACCOUNT_LENGTH = 10;

    public Ejercicio2() {
        super("Validación de Número de Cuenta");
        initUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 180);
        setLocationRelativeTo(null);
    }

    private void initUI() {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel prompt = new JLabel("Ingresa un número de cuenta (10 dígitos):");
        p.add(prompt, BorderLayout.NORTH);

        accountField = new JTextField();
        ((AbstractDocument) accountField.getDocument()).setDocumentFilter(new DigitFilter(ACCOUNT_LENGTH));
        accountField.setFont(accountField.getFont().deriveFont(16f));
        p.add(accountField, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(6, 6));
        statusLabel = new JLabel("Esperando entrada...");
        statusLabel.setForeground(Color.DARK_GRAY);
        bottom.add(statusLabel, BorderLayout.WEST);

        countLabel = new JLabel("0/" + ACCOUNT_LENGTH);
        bottom.add(countLabel, BorderLayout.EAST);

        p.add(bottom, BorderLayout.SOUTH);

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton validateBtn = new JButton("Validar");
        JButton clearBtn = new JButton("Limpiar");
        controls.add(clearBtn);
        controls.add(validateBtn);

        add(p, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);

        accountField.getDocument().addDocumentListener(new SimpleDocListener() {
            @Override
            public void update() {
                String text = accountField.getText();
                countLabel.setText(text.length() + "/" + ACCOUNT_LENGTH);
                updateStatus(text);
            }
        });

        validateBtn.addActionListener(e -> {
            String acc = accountField.getText();
            if (isValidAccountNumber(acc)) {
                JOptionPane.showMessageDialog(this, "El número de cuenta es válido.", "Válido", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Número de cuenta inválido. Debe tener exactamente 10 dígitos numéricos.", "Inválido", JOptionPane.ERROR_MESSAGE);
            }
        });

        clearBtn.addActionListener(e -> {
            accountField.setText("");
            accountField.requestFocusInWindow();
        });

        accountField.addActionListener(e -> validateBtn.doClick());
    }

    private void updateStatus(String text) {
        if (text.length() == 0) {
            statusLabel.setText("Esperando entrada...");
            statusLabel.setForeground(Color.DARK_GRAY);
        } else if (text.length() < ACCOUNT_LENGTH) {
            statusLabel.setText("✘ Incompleto (" + text.length() + "/" + ACCOUNT_LENGTH + ")");
            statusLabel.setForeground(new Color(180, 50, 50));
        } else if (text.length() == ACCOUNT_LENGTH) {
            statusLabel.setText("✔ Longitud correcta. Puedes validar.");
            statusLabel.setForeground(new Color(0, 120, 0));
        } else {
            statusLabel.setText("✘ Demasiados dígitos");
            statusLabel.setForeground(new Color(180, 50, 50));
        }
    }

    public static boolean isValidAccountNumber(String accountNumber) {
        return accountNumber != null && accountNumber.matches("\\d{" + ACCOUNT_LENGTH + "}");
    }

    static class DigitFilter extends DocumentFilter {
        private final int max;

        DigitFilter(int max) { this.max = max; }

        @Override
        public void insertString(FilterBypass fb, int off, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) return;
            String filtered = filterDigits(str);
            int newLen = fb.getDocument().getLength() + filtered.length();
            if (newLen <= max) super.insertString(fb, off, filtered, attr);
            else super.insertString(fb, off, filtered.substring(0, Math.max(0, max - fb.getDocument().getLength())), attr);
        }

        @Override
        public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) return;
            String filtered = filterDigits(str);
            int newLen = fb.getDocument().getLength() - len + filtered.length();
            if (newLen <= max) super.replace(fb, off, len, filtered, attr);
            else super.replace(fb, off, len, filtered.substring(0, Math.max(0, max - (fb.getDocument().getLength() - len))), attr);
        }

        @Override
        public void remove(FilterBypass fb, int off, int len)throws BadLocationException {
            super.remove(fb, off, len);
        }

        private String filterDigits(String s) {
            StringBuilder b = new StringBuilder(s.length());
            for (char c : s.toCharArray()) if (Character.isDigit(c)) b.append(c);
            return b.toString();
        }
    }

    abstract static class SimpleDocListener implements javax.swing.event.DocumentListener {
        public abstract void update();
        public void insertUpdate(javax.swing.event.DocumentEvent e) {update();}
        public void removeUpdate(javax.swing.event.DocumentEvent e) {update();}
        public void changedUpdate(javax.swing.event.DocumentEvent e) {update();}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio2().setVisible(true);
        });
    }
}
