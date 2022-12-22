package tw.leonchen.action;

import java.util.ArrayList;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import tw.leonchen.model.TruckBean;

public class DemoSpelAction {

	public static void main(String[] args) {
		SpelExpressionParser parser = new SpelExpressionParser();
		
		Expression express1 = parser.parseExpression("'hola,' + ' Amigo!!'");
		String result1 = express1.getValue(String.class);
		System.out.println("result1:" + result1);
		
		Expression express2 = parser.parseExpression("2*3+1");
		Integer result2 = express2.getValue(Integer.class);
		System.out.println("result2:" + result2);
		
		StandardEvaluationContext ectx = new StandardEvaluationContext();
		
		TruckBean truck1 = new TruckBean(100,"Lexus");
		TruckBean truck2 = new TruckBean(100,"Ferrari");
		
		ArrayList<TruckBean> trucks = new ArrayList<TruckBean>();
		trucks.add(truck1);
		trucks.add(truck2);
		
		ectx.setVariable("trucks", trucks);
		
		String brand = parser.parseExpression("#trucks[0].brand").getValue(ectx, String.class);
		System.out.println("brand:" + brand);
	}

}
