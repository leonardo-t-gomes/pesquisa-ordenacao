/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laboratorio
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Produto> listaProduto = new ArrayList<>();
        LocalDate dataAtual = LocalDate.now();
        
        listaProduto.add(new Produto(1,"amendoin",dataAtual));
        listaProduto.add(new Produto(4,"Pao de forma pullmann",dataAtual));
        listaProduto.add(new Produto(2,"Pão de forma Tubino",LocalDate.parse("2026-08-28")));
        listaProduto.add(new Produto(3,"Brocolis",dataAtual));

        listaProduto.sort((p1,p2) -> p1.getData().compareTo(p1.getData()));
        
        
        for (Produto item : listaProduto) {
                System.out.println(item);
        }
        
    }
    
    
}
