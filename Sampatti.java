import javax.swing.*;
import java.awt.*;

public class SampattiBankUI extends JFrame {
    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    private final JDialog loginDialog;
    private boolean isLoggedIn = false;

    public SampattiBankUI() {
        setTitle("Sampatti Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Navbar
        add(createNavbar(), BorderLayout.NORTH);

        // Main Sections
        mainPanel.add(createBannerPanel(), "Home");
        mainPanel.add(createServicesPanel(), "Services");
        mainPanel.add(createAboutPanel(), "About");
        mainPanel.add(createContactPanel(), "Contact");
        mainPanel.add(createAccountDetailsPanel(), "AccountDetails");

        add(mainPanel, BorderLayout.CENTER);

        // Login Dialog
        loginDialog = createLoginDialog();

        cardLayout.show(mainPanel, "Home");
    }

    private JPanel createNavbar() {
        JPanel navbar = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        navbar.setBackground(new Color(0, 68, 204));
        navbar.setPreferredSize(new Dimension(800, 60));

        JLabel logo = new JLabel("Sampatti Bank");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Arial", Font.BOLD, 20));
        navbar.add(logo);

        JButton homeBtn = new JButton("Home");
        homeBtn.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        JButton servicesBtn = new JButton("Services");
        servicesBtn.addActionListener(e -> cardLayout.show(mainPanel, "Services"));

        JButton aboutBtn = new JButton("About");
        aboutBtn.addActionListener(e -> cardLayout.show(mainPanel, "About"));

        JButton contactBtn = new JButton("Contact");
        contactBtn.addActionListener(e -> cardLayout.show(mainPanel, "Contact"));

        JButton loginBtn = new JButton("Account");
        loginBtn.setBackground(new Color(255, 165, 0));
        loginBtn.addActionListener(e -> {
            if (isLoggedIn) {
                cardLayout.show(mainPanel, "AccountDetails");
            } else {
                loginDialog.setVisible(true);
            }
        });

        navbar.add(homeBtn);
        navbar.add(servicesBtn);
        navbar.add(aboutBtn);
        navbar.add(contactBtn);
        navbar.add(loginBtn);

        return navbar;
    }

    private JPanel createBannerPanel() {
        JPanel banner = new JPanel();
        banner.setLayout(new BoxLayout(banner, BoxLayout.Y_AXIS));
        banner.setBackground(new Color(224, 247, 250));
        banner.setPreferredSize(new Dimension(800, 200));

        JLabel welcomeLabel = new JLabel("Welcome to Sampatti Bank", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(new Color(0, 68, 204));

        JLabel subLabel = new JLabel("Where Your Wealth Finds a Home", SwingConstants.CENTER);
        subLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subLabel.setForeground(Color.DARK_GRAY);

        JButton learnMoreBtn = new JButton("Learn More");
        learnMoreBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Welcome to Sampatti Bank! We offer tailored solutions to meet all your financial needs."));

        banner.add(Box.createVerticalStrut(50));
        banner.add(welcomeLabel);
        banner.add(subLabel);
        banner.add(Box.createVerticalStrut(20));
        banner.add(learnMoreBtn);

        return banner;
    }

    private JPanel createServicesPanel() {
        JPanel servicesPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        servicesPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        servicesPanel.setBackground(new Color(248, 249, 250));

        JPanel personalBankingCard = createServiceCard("Personal Banking", "Manage your personal finances with ease. Ideal for day-to-day expenses and savings.");
        JPanel loansCard = createServiceCard("Loans", "Get quick loans with flexible options tailored for your financial needs.");
        JPanel investmentsCard = createServiceCard("Investments", "Grow your wealth with our secure and profitable investment plans.");

        servicesPanel.add(personalBankingCard);
        servicesPanel.add(loansCard);
        servicesPanel.add(investmentsCard);

        return servicesPanel;
    }

    private JPanel createServiceCard(String title, String description) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        card.setBackground(Color.WHITE);
        card.setPreferredSize(new Dimension(200, 200));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(0, 68, 204));

        JLabel descriptionLabel = new JLabel("<html><center>" + description + "</center></html>", SwingConstants.CENTER);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setForeground(Color.DARK_GRAY);

        JButton learnMoreBtn = new JButton("Learn More");
        learnMoreBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Explore more about our " + title + " services."));

        card.add(Box.createVerticalStrut(15));
        card.add(titleLabel);
        card.add(descriptionLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(learnMoreBtn);

        return card;
    }

    private JPanel createAboutPanel() {
        JPanel aboutPanel = new JPanel();
        aboutPanel.setBackground(new Color(244, 246, 248));
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("About Us", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 68, 204));

        JLabel descriptionLabel = new JLabel("<html><center>We are a customer-focused bank dedicated to financial excellence. Our mission is to help you achieve your goals with personalized banking solutions.</center></html>", SwingConstants.CENTER);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setForeground(Color.DARK_GRAY);

        aboutPanel.add(Box.createVerticalStrut(50));
        aboutPanel.add(titleLabel);
        aboutPanel.add(descriptionLabel);

        return aboutPanel;
    }

    private JPanel createContactPanel() {
        JPanel contactPanel = new JPanel();
        contactPanel.setBackground(new Color(244, 246, 248));
        contactPanel.setLayout(new BoxLayout(contactPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Contact Us", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 68, 204));

        JLabel emailLabel = new JLabel("Email: contact@SampattiBank.com", SwingConstants.CENTER);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailLabel.setForeground(Color.DARK_GRAY);

        JLabel phoneLabel = new JLabel("Phone: +123 456 789", SwingConstants.CENTER);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneLabel.setForeground(Color.DARK_GRAY);

        contactPanel.add(Box.createVerticalStrut(50));
        contactPanel.add(titleLabel);
        contactPanel.add(emailLabel);
        contactPanel.add(phoneLabel);

        return contactPanel;
    }

    private JPanel createAccountDetailsPanel() {
        JPanel accountPanel = new JPanel();
        accountPanel.setBackground(new Color(248, 249, 250));
        accountPanel.setLayout(new BoxLayout(accountPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Account Details", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 68, 204));

        JLabel nameLabel = new JLabel("Account Holder: Yashovardhan Thopte", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel accountNumberLabel = new JLabel("Account Number: 123456789", SwingConstants.CENTER);
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel balanceLabel = new JLabel("Balance: ₹500,000", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel branchLabel = new JLabel("Branch: Downtown Mumbai", SwingConstants.CENTER);
        branchLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        accountPanel.add(Box.createVerticalStrut(20));
        accountPanel.add(titleLabel);
        accountPanel.add(nameLabel);
        accountPanel.add(accountNumberLabel);
        accountPanel.add(balanceLabel);
        accountPanel.add(branchLabel);

        return accountPanel;
    }

    private JDialog createLoginDialog() {
        JDialog dialog = new JDialog(this, "Login", true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new GridLayout(3, 2, 10, 10));

        dialog.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        dialog.add(usernameField);

        dialog.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        dialog.add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Login successful (mock)!");
            isLoggedIn = true;
            dialog.dispose();
        });
        dialog.add(loginBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> dialog.dispose());
        dialog.add(cancelBtn);

        return dialog;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SampattiBankUI().setVisible(true);
        });
    }
}