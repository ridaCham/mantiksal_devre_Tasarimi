package _19670310003_ridha_chame;

import java.util.ArrayList;
import java.util.Scanner;

public class _19670310003_Main_class {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        _19670310003_FunctionManager manager = new _19670310003_FunctionManager();
        ArrayList<String> variables = new ArrayList<String>();
        ArrayList<String> myfunctionSymbols = new ArrayList<String>();
        int variablesAccount = 0;
        String userEntry = "";
        for (int i = 0; i < manager.getVariablesNames().replace(" ", "").length(); i++) {
            if (i < manager.getVariablesNames().replace(" ", "").indexOf("|")) {
                variablesAccount++;
                variables.add(String.valueOf(manager.getVariablesNames().replace(" ", "").charAt(i)));
            } else if (i > manager.getVariablesNames().replace(" ", "").indexOf("|")) {
                myfunctionSymbols.add(String.valueOf(manager.getVariablesNames().replace(" ", "").charAt(i)));
            }
        }
        for (String functionSymbol : myfunctionSymbols) {
        if (manager.getVariablesNames().replace(" ", "").contains(functionSymbol)) {
            _19670310003_Function myFunction = new _19670310003_Function(functionSymbol);
            _19670310003_FunctionManager myManager = new _19670310003_FunctionManager(myFunction);
            
            for (String variable : variables) {
                System.out.println("lütfen " + functionSymbol + " fonksyonu için " + variable + " değişkeninin değerini giriniz: ");
                userEntry = userEntry.concat(scan.next());
            }

            System.out.println("Girilen değerlere göre " + functionSymbol + " fonksiyonunun çıkışı " + myManager.getValueOfFunction(userEntry) + " dir");
        
        }
    }
    
}
}
