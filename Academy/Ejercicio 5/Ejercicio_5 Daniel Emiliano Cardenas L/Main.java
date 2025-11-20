import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    
}
class Account {
    private BigDecimal balance;

    Account(BigDecimal initial) {
        this.balance = initial.max(BigDecimal.ZERO);
    }

    synchronized BigDecimal getBalance() {
        return balance;
    }

    synchronized void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Debe ser positivo");
        balance = balance.add(amount);
    }

    synchronized void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Debe ser positivo");
        if (amount.compareTo(balance) > 0) throw new IllegalArgumentException("Saldo insuficiente");
        balance = balance.subtract(amount);
    }
}

class ATMFrame extends JFrame {
    private final Account account;
    private final JLabel balanceLabel;
    private final NumberFormat moneyFmt = NumberFormat.getCurrencyInstance(new Locale("es","ES"));

    ATMFrame(Account account) {
        super("Simulador de Cajero Automático");
        this.account = account;
        balanceLabel = new JLabel();
        updateBalanceLabel();

        JButton consultarBtn = new JButton("Consultar saldo");
        JButton depositarBtn = new JButton("Depositar");
        JButton retirarBtn = new JButton("Retirar");
        JButton salirBtn = new JButton("Salir");

        consultarBtn.addActionListener(e -> updateBalanceLabelAndNotify());
        depositarBtn.addActionListener(e -> handleDeposit());
        retirarBtn.addActionListener(e -> handleWithdraw());
        salirBtn.addActionListener(e -> System.exit(0));

        JPanel btnPanel = new JPanel(new GridLayout(2, 2, 8, 8));
        btnPanel.add(consultarBtn);
        btnPanel.add(depositarBtn);
        btnPanel.add(retirarBtn);
        btnPanel.add(salirBtn);

        JPanel top = new JPanel(new BorderLayout(8, 8));
        top.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        top.add(new JLabel("Saldo actual:"), BorderLayout.WEST);
        top.add(balanceLabel, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(btnPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 160);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText(moneyFmt.format(account.getBalance()));
    }

    private void updateBalanceLabelAndNotify() {
        updateBalanceLabel();
        JOptionPane.showMessageDialog(this,
                "Saldo: " + moneyFmt.format(account.getBalance()),
                "Consulta de saldo",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleDeposit() {
        String input = JOptionPane.showInputDialog(this, "Ingrese cantidad a depositar:", "Depositar", JOptionPane.PLAIN_MESSAGE);
        if (input == null) return;
        input = input.trim().replace(',', '.');
        try {
            BigDecimal amount = new BigDecimal(input);
            account.deposit(amount);
            updateBalanceLabel();
            JOptionPane.showMessageDialog(this, "Depósito realizado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada no válida. Use números (por ejemplo 1500.50).", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleWithdraw() {
        String input = JOptionPane.showInputDialog(this, "Ingrese cantidad a retirar:", "Retirar", JOptionPane.PLAIN_MESSAGE);
        if (input == null) return;
        input = input.trim().replace(',', '.');
        try {
            BigDecimal amount = new BigDecimal(input);
            account.withdraw(amount);
            updateBalanceLabel();
            JOptionPane.showMessageDialog(this, "Retiro realizado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada no válida. Use números (por ejemplo 500.00).", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class ATMApp {
    public static void main(String[] args) {
        Account initial = new Account(new BigDecimal("1000.00"));
        SwingUtilities.invokeLater(() -> new ATMFrame(initial));
    }

}
