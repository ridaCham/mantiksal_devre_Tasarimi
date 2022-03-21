package _19670310003_ridha_chame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _19670310003_FunctionManager {

    _19670310003_Function function;
    File dataFile = new File("./../../files/dogruluk_tablosu.txt");//C:\Users\ user\Desktop\files/dogruluk_tablosu.txt

    public _19670310003_FunctionManager() {
    }

    public _19670310003_FunctionManager(_19670310003_Function myFunction) {
        this.function = myFunction;
        this.createFunctionFormula(myFunction.symbol);
        this.WriteFormula(myFunction.symbol);
    }

    public void createFunctionFormula(String fuctionSymbol) {
        int bol = this.getVariablesNames().indexOf(fuctionSymbol);
        try {
            Scanner reader = new Scanner(dataFile);
            reader.nextLine();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String binaryValueOfTerms = line.substring(0, line.indexOf("|"));
                int decimalValueOfTerms = Integer.parseInt(binaryValueOfTerms.replace(" ", ""), 2);
                String alphFormOfTerms = "";
                if (String.valueOf(line.charAt(bol)).equals("1")) {
                    function.min.add(String.valueOf(decimalValueOfTerms));
                    function.top_min.add("m" + decimalValueOfTerms);
                    for (int i = 0; i < this.getVariablesNames().substring(0, this.getVariablesNames().indexOf("|")).length(); i++) {
                        if (String.valueOf(line.charAt(i)).equals("0")) {
                            alphFormOfTerms = alphFormOfTerms.concat(String.valueOf(this.tumleyen(this.getVariablesNames().charAt(i))));
                        } else if (String.valueOf(line.charAt(i)).equals("1")) {
                            alphFormOfTerms = alphFormOfTerms.concat(String.valueOf(this.getVariablesNames().charAt(i)));
                        }
                    }
                    function.std_min.add(alphFormOfTerms);
                } else if (String.valueOf(line.charAt(bol)).equals("0")) {
                    function.max.add(String.valueOf(decimalValueOfTerms));
                    function.car_max.add("M" + decimalValueOfTerms);
                    for (int i = 0; i < this.getVariablesNames().substring(0, this.getVariablesNames().indexOf("|")).length(); i++) {
                        if (line.charAt(i) == '0') {
                            if (i == line.substring(0, this.getVariablesNames().indexOf("|")).length() - 2) {
                                alphFormOfTerms += this.tumleyen(this.getVariablesNames().charAt(i));
                            } else {
                                alphFormOfTerms += (this.tumleyen(this.getVariablesNames().charAt(i)) + "+");
                            }
                        } else if (line.charAt(i) == '1') {
                            if (i == line.substring(0, this.getVariablesNames().indexOf("|")).length() - 2) {
                                alphFormOfTerms += (this.getVariablesNames().charAt(i));
                            } else {
                                alphFormOfTerms += ((this.getVariablesNames().charAt(i)) + "+");
                            }
                        }
                    }
                    function.std_max.add("(" + alphFormOfTerms + ")");
                }
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("error :" + ex.getMessage());
        }
    }

    public void WriteFormula(String fuctionSymbol) {
        int bol = this.getVariablesNames().indexOf(fuctionSymbol);
        for (String m : function.min) {
            if (function.min.indexOf(m) == 0) {
                System.out.print(this.getVariablesNames().charAt(bol) + " = Σ(");
            }
            System.out.print(m);
            if (function.min.indexOf(m) != function.min.size() - 1) {
                System.out.print(",");
            } else {
                System.out.print(") = ");
            }
        }
        for (String m : function.top_min) {
            System.out.print(m);
            if (function.top_min.indexOf(m) != function.top_min.size() - 1) {
                System.out.print(" + ");
            } else {
                System.out.print(" = ");
            }
        }
        for (String m : function.std_min) {
            System.out.print(m);
            if (function.std_min.indexOf(m) != function.std_min.size() - 1) {
                System.out.print(" + ");
            }
        }
        System.out.println("");
        for (String m : function.max) {
            if (function.max.indexOf(m) == 0) {
                System.out.print(this.getVariablesNames().charAt(bol) + "=∏(");
            }
            System.out.print(m);
            if (function.max.indexOf(m) != function.max.size() - 1) {
                System.out.print(",");
            } else {
                System.out.print(")= ");
            }
        }
        for (String m : function.car_max) {
            System.out.print(m);
            if (function.car_max.indexOf(m) != function.car_max.size() - 1) {
                System.out.print(".");
            } else {
                System.out.print("=");
            }
        }
        for (String m : function.car_max) {
            System.out.print(m);
            if (function.car_max.indexOf(m) != function.car_max.size() - 1) {
                System.out.print(".");
            } else {
                System.out.print("=");
            }
        }
        for (String m : function.std_max) {
            System.out.print(m);
            if (function.std_max.indexOf(m) != function.std_max.size() - 1) {
                System.out.print(".");
            }
        }
        System.out.println("");
    }

    public String tumleyen(char x) {
        return x + "'";
    }

    public String getVariablesNames() {
        String variablesAndFunctions = "";
        try {
            Scanner reader = new Scanner(dataFile);
            variablesAndFunctions = reader.nextLine();
        } catch (FileNotFoundException ex) {
            System.out.println("error :" + ex.getMessage());
        }
        return variablesAndFunctions;
    }

    public String getValueOfFunction(String userEntry) {
        String line = "";
        try {
            Scanner reader = new Scanner(dataFile);
            String variablesValue = "";
            while (reader.hasNext()) {
                variablesValue = reader.nextLine();
                if (variablesValue.substring(0, variablesValue.indexOf("|")).replace(" ", "").equals(userEntry)) {
                    line = variablesValue.substring(this.getVariablesNames().indexOf(function.symbol), this.getVariablesNames().indexOf(function.symbol) + 1);
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("error :" + ex.getMessage());
        }
        return line;
    }
}