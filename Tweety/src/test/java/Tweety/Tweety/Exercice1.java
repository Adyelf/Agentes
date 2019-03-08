package Tweety.Tweety;

import java.util.HashSet;
import java.util.Set;

import net.sf.tweety.logics.pl.syntax.Disjunction;
import net.sf.tweety.logics.pl.syntax.Negation;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

public class Exercice1 {
	public static void main(String[] args){
		Proposition a = new Proposition("a");
		Proposition b = new Proposition("b");
		Proposition c = new Proposition("c");
		Proposition d = new Proposition("d");
		
		PropositionalFormula formula1 = a.combineWithOr(b.combineWithAnd(c));
		
		// Aqui realizamos : a^b
		PropositionalFormula formulaA = a.combineWithAnd(b);
		
		//Aqui realizamos  : a^(!b)
		PropositionalFormula formulaB = a.combineWithAnd(b.complement());
		PropositionalFormula formulaY = a.combineWithAnd(new Negation(b));
		
		// 1 forma - Podemos combinar com outras formulas o argumento
		// Aqui realizamos : a^(b^c)
		PropositionalFormula formulaC = b.combineWithAnd(c);
		PropositionalFormula formulaX = a.combineWithAnd(formulaC);
		
		// 2forma
		// Aqui realizamos : a^(b^c)
		PropositionalFormula formulaD = a.combineWithAnd(b.combineWithAnd(c));
		
		// 3 forma : a^(b^c)
		PropositionalFormula formulaF = b.combineWithAnd(c).combineWithAnd(a);
		
		
		// Aqui realizamos a||b
		PropositionalFormula formulaG = a.combineWithOr(b);
		
		// Aqui realizamos varias negações !(!(!a)^!b)
		PropositionalFormula formula3 = new Negation((new Negation(new Negation(a))).combineWithAnd(new Negation(b)));
	
		
		
		//Dizemos que vamos usar varias variaveis e queremos colocar uma coisa comum entre elas.
		// no caso, será o ||
		// Damos nome a uma variavel (set)
		Set<PropositionalFormula> set = new HashSet<PropositionalFormula>();
		
		//Adicionamos variaveis a ela
		set.add(a);
		set.add(b);
		set.add(c);
		set.add(new Negation(d));
		PropositionalFormula formula4 = new Disjunction(set);
		

		
		

		System.out.println(formula3);
		System.out.println(formula4);
		System.out.println(formulaA);
		
		System.out.println(formulaB);
		System.out.println(formulaY);
		System.out.println(formulaD);
		System.out.println(formulaX);
		System.out.println(formulaF);
		System.out.println(formulaG);
		


	}
}