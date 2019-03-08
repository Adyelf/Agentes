package Tweety.Tweety;

import java.util.HashSet;
import java.util.Set;

import net.sf.tweety.logics.pl.syntax.Conjunction;
import net.sf.tweety.logics.pl.syntax.Disjunction;
import net.sf.tweety.logics.pl.syntax.Negation;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
public class Exercice2 {
	public static void main(String[] args){
		Proposition a = new Proposition("a");
		Proposition b = new Proposition("b");
		Proposition c = new Proposition("c");
		Proposition d = new Proposition("d");
		
		PropositionalFormula formula1 = a.combineWithAnd(a);
		PropositionalFormula formula2 = a.combineWithAnd(a);
		PropositionalFormula formula3 = a.combineWithAnd(c);
		
	//	PropositionalFormula formula3 = new Negation((new Negation(new Negation(a))).combineWithAnd(new Negation(b)));
		
		Set<PropositionalFormula> set = new HashSet<PropositionalFormula>();
		set.add(a);
		set.add(b);
		set.add(c);
		PropositionalFormula formula4 = new Disjunction(set);
		
		set = new HashSet<PropositionalFormula>();
		set.add(formula1);
		set.add(formula2);
		set.add(formula3);
		PropositionalFormula formula5 = new Disjunction(set);
		
		System.out.println(formula5);
		
		formula5 = formula5.toCnf();
		
		System.out.println(formula5);
	}
}