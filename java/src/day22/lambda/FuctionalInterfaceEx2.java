package day22.lambda;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FuctionalInterfaceEx2 {

	public static void main(String[] args) {
		// Supplier 인터페이스
		Supplier<String> supplier = () -> "Hi";
		System.out.println(supplier.get());
		
		// Function 인터페이스
		Function<Student, String> function = std -> std.getName();
		System.out.println(function.apply(new Student(1,1,1,"Hong")));
		
		
		// Operator
		UnaryOperator<Student> operator = std -> {
			std.setGrade(2); 
			return std;
		};
		System.out.println(operator.apply(new Student(1,1,1,"Hong")));
		
		// Predicate
		Predicate<Student> predicate = s -> s.getName().indexOf("Hong") == 0;
		System.out.println(predicate.test(new Student(1,1,1,"Hong")));
		
		//
	}

}
