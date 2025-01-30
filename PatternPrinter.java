// import java.util.Scanner;

// public class PatternPrinter {
//     public static void floyds() {
//         try (Scanner sc = new Scanner(System.in)) {
//             if (sc.hasNextInt()) {
//                 int a = sc.nextInt();
//                 for (int i = 1, k = 1; i <= a; i++) {
//                     for (int j = 1; j <= i; j++, k++) {
//                         if (k < 10)
//                             System.out.print(k + "  ");
//                         else
//                             System.out.print(k + " ");
//                     }
//                     System.out.println();
//                 }
//             }
//         }
//     }

//     public static void rev() {
//         try (Scanner sc = new Scanner(System.in)) {
//             if (sc.hasNextInt()) {
//                 int a = sc.nextInt();
//                 for (int i = 1; i <= a; i++) {
//                     for (int j = 1; j <= a - i + 1; j++) {
//                         System.out.print(j);
//                     }
//                     System.out.println();
//                 }
//             }
//         }

//     }

//     public static void zon() {
//         try (Scanner sc = new Scanner(System.in)) {
//             if (sc.hasNextInt()) {
//                 int a = sc.nextInt();
//                 for (int i = 1; i <= a; i++) {
//                     for (int j = 1, k = (i % 2 == 0) ? 0 : 1; j <= i; j++, k = (k == 1) ? (k - 1) : (1 + k)) {
//                         System.out.print(k + " ");
//                     }
//                     System.out.println();
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {
//         zon();
//         rev();
//         floyds();
//     }

// }

import java.util.Scanner;

public class PatternPrinter {

    // Method to print Floyd's triangle
    public static void floyds(Scanner sc) {
        System.out.print("Enter the number of rows for Floyd's triangle: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            for (int i = 1, k = 1; i <= a; i++) {
                for (int j = 1; j <= i; j++, k++) {
                    if (k < 10)
                        System.out.print(k + "  ");
                    else
                        System.out.print(k + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    // Method to print reverse pattern
    public static void reversePattern(Scanner sc) {
        System.out.print("Enter the number of rows for the reverse pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= a - i + 1; j++) {
                    System.out.print(j);
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    // Method to print zon pattern
    public static void zonPattern(Scanner sc) {
        System.out.print("Enter the number of rows for the zon pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            for (int i = 1; i <= a; i++) {
                for (int j = 1, k = (i % 2 == 0) ? 0 : 1; j <= i; j++, k = (k == 1) ? (k - 1) : (1 + k)) {
                    System.out.print(k + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    public static void zonPattern1(Scanner sc) {
        System.out.print("Enter the number of rows for the zon pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= i; j++) {
                    if ((i + j) % 2 == 0) {
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    public static void butterfly(Scanner sc) {
        System.out.print("Enter the number of rows for the butterfly pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= a; j++) {
                    if (i <= a / 2 && j <= a / 2) {
                        if (j <= i) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    } else if (i <= a / 2 && j >= a / 2) {
                        if (j >= a + 1 - i) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    } else if (i >= a / 2 && j <= a / 2) {
                        if (j <= a + 1 - i) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    } else {
                        if (j > i - 1) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    public static void rhombusfi(Scanner sc) {
        System.out.print("Enter the number of rows for the rhombus pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = a * 2;
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= b - 1; j++) {
                    if (j <= a) {
                        if (j >= a - i + 1) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    } else {
                        if (j - a <= a - i) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    public static void rhombusfi1(Scanner sc) {
        System.out.print("Enter the number of rows for the rhombus pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= a - i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= a; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    public static void rhombuslined(Scanner sc) {
        System.out.print("Enter the number of rows for the rhombus pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = a * 2;
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= b - 1; j++) {
                    if (j <= a) {
                        if (i == a) {
                            System.out.print("* ");
                        } else if (j == a - i + 1) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    } else {
                        if (i == 1) {
                            System.out.print("* ");
                        } else if (j - a == a - i) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    public static void rhombuslined1(Scanner sc) {
        System.out.print("Enter the number of rows for the rhombus pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= a - i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= a; j++) {
                    if (i == 1 || j == 1 || j == a || i == a) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    public static void numpyramidMy(Scanner sc) {
        System.out.print("Enter the number of rows for the number pyramid pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt(), k, m = 0;
            for (int i = 1; i <= a; i++) {
                k = i;
                m = 0;
                for (int j = 1; j <= a * 2 - 1; j++) {
                    if (m == 1) {
                        System.out.print(" ");
                        m = 0;
                    } else if (k > 0 && j >= a - i + 1 && j <= a + i - 1) {
                        System.out.print(i);
                        k--;
                        m = 1;
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }

    }

    public static void numpyramidChat(Scanner sc) {
        System.out.print("Enter the number of rows for the number pyramid pattern: ");
        if (sc.hasNextInt()) {
            int rows = sc.nextInt();
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= rows - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print(i);
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    public static void numpyramid2(Scanner sc) {
        System.out.print("Enter the number of rows for the number pyramid pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt(), k, l;
            for (int i = 1; i <= a; i++) {
                k = i;
                l = i;
                for (int j = 1; j <= a * 2 - 1; j++) {
                    if (j <= a) {
                        if (k > 0 && j >= a - i + 1) {
                            System.out.print(l);
                            k--;
                            if (l > 1) {
                                l--;
                            }
                        } else {
                            System.out.print(" ");
                        }
                    } else {
                        if (i == 1) {
                            System.out.print(" ");
                        } else if (j - a <= i - 1) {
                            l++;
                            System.out.print(l);
                        } else {
                            System.out.print(" ");

                        }
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    public static void numpyramid3(Scanner sc) {
        System.out.print("Enter the number of rows for the number pyramid pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= a - i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1,k=i,m=0; j <= i * 2 - 1; j++,k=(k>1 && m==0)?k-1:k+1,m=(k==1)?1:m) {
                    System.out.print(k+" ");
                }
                System.out.println();
            }
        }
    }

    public static void diamond(Scanner sc) {
        System.out.print("Enter the number of rows for the number pyramid pattern: ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= a - i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= i * 2 - 1; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            for (int i = a - 1; i >= 1; i--) {
                for (int j = 1; j <= a - i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= i * 2 - 1; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }

    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // zonPattern(sc);
            // zonPattern1(sc);
            // reversePattern(sc);
            // floyds(sc);
            // butterfly(sc);
            // rhombusfi(sc);
            // rhombusfi1(sc);
            // rhombuslined(sc);
            // rhombuslined1(sc);
            // numpyramidMy(sc);
            // numpyramidChat(sc);
            // numpyramid2(sc);
            numpyramid3(sc);
            // diamond(sc);
        }
    }
}