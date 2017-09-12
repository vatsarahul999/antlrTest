import java.util.ArrayList;
import java.util.List;

import com.CBaseListener;
import com.CParser.FunctionDefinitionContext;

public class CReader extends CBaseListener{
	
	private List<String> functionName;
	
	public CReader(){
		functionName = new ArrayList<>();
	}


	@Override
	public void exitFunctionDefinition(FunctionDefinitionContext ctx) {
		// TODO Auto-generated method stub
		functionName.add(ctx.getText());
		
	}

	public List<String> getFunctionName() {
		return functionName;
	}

	public void setFunctionName(List<String> functionName) {
		this.functionName = functionName;
	}

}
