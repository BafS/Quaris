import javax.script.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public void addBadge(String badgeName) {
        System.out.println("Badge [" + badgeName + "] added !");
    }

    public static void main(String[] args) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
//            engine.eval("var fun1 = function(user) { print('user is: ' + user); }");

            engine.eval("var fun1 = function(user, scales) {" +
                    "var Helper = Java.type('Main');" +
                    "var quaris = new Helper();" +
                    "print('user is: ' + user + ', replies:' + scales.replies);" +
                    "quaris.addBadge('asd');" +
                    "}");

//            final Bindings bindings = engine.createBindings();
//            bindings.put("quaris", new JavaHelper());
//            engine.setBindings(bindings, ScriptContext.GLOBAL_SCOPE);

            Invocable invocable = (Invocable) engine;

            Map<String, Object> scales = new HashMap<>();
            scales.put("replies", 10);
            scales.put("level", 1250);

            Object result = invocable.invokeFunction("fun1", "Testuser", scales);
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
