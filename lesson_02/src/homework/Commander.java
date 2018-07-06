package homework;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Commander {
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            try (Connection conn = MyConnection.getConnection()) {
                String[] commands;
                boolean noExit = true;
                do {
                    System.out.println("Введите команду");
                    commands = scanner.nextLine().split(" ", 0);
                    if (!commands[0].startsWith("/")) {
                        System.out.println(commands[0] + " не является командой!");
                        continue;
                    }
                    switch (commands[0]) {
                        case "/цена":
                            if (commands.length > 1) {
                                showCost(conn, commands[1]);
                            } else {
                                System.out.println("Недостаточно аргументов");
                            }
                            break;
                        case "/сменитьцену":
                            if (commands.length > 2) {
                                try {
                                    float cost = Float.parseFloat(commands[2]);
                                    changeCost(conn, commands[1], cost);
                                } catch (NumberFormatException e) {
                                    System.out.println("Неверные аргументы");
                                }
                            } else {
                                System.out.println("Недостаточно аргументов");
                            }
                            break;
                        case "/товарыпоцене":
                            if (commands.length > 2) {
                                try {
                                    float cost1 = Float.parseFloat(commands[1]);
                                    float cost2 = Float.parseFloat(commands[2]);
                                    showProductsForCostRange(conn, cost1, cost2);
                                } catch (NumberFormatException e) {
                                    System.out.println("Неверные аргументы");
                                }
                            } else {
                                System.out.println("Недостаточно аргументов");
                            }
                            break;
                        case "/выход":
                            System.out.println("Выход");
                            noExit = false;
                            break;
                        default:
                            System.out.println(commands[0] + " неизвестная команда");
                    }
                } while (noExit);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showProductsForCostRange(Connection conn, float cost1, float cost2) {
        String query = "SELECT title FROM products WHERE  cost >= ? AND cost <= ?;";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setFloat(1, cost1 < cost2 ? cost1 : cost2);
            ps.setFloat(2, cost1 > cost2 ? cost1 : cost2);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showCost(Connection conn, String title) {
        String query = "SELECT cost FROM products WHERE  title = ?;";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, title);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getFloat(1));
                } else {
                    System.out.println("Такого товара нет");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void changeCost(Connection conn, String title, float cost) {
        String query = "UPDATE products SET cost = ?  WHERE title = ?;";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setFloat(1, cost);
            ps.setString(2, title);
            if (ps.executeUpdate() > 0) {
                System.out.println("Цена изменена");
            } else {
                System.out.println("Такого товара нет");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
