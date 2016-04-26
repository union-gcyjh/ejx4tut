/**
 * 项目内所有的静态变量。<br>
 * 避免一些固定变量的变动所造成的对项目代码改动负担。
 *
 * @author DJQ
 * @updateData 2015年1月21日
 */
var staticParam = $.extend({}, staticParam);

staticParam.webModel_iframe = "0";

staticParam.webModel_pureMVC = "1";

staticParam.action_reqPath_main = "/ajax/ejx4web.action";
//ejx4web.jar中
////<action name="ejx4web">
//<result name="success" type="framework.textresult" />
//</action>

//ejx4framework-4.0-SNAPSHOT.jar中
//<package name="framework" extends="struts-default" abstract="true">
//<result-types>
//	<result-type name="framework.textresult" class="com.tienon.framework.io.struts2.PlainTextResult">//此类只接收传递值,准备数据由Ajax提供,故可通用
//		<param name="charset">UTF-8</param>
//	</result-type>
//staticParam.action_reqPath_login = "/ajax/login.action";

staticParam.page_path_root = "page";

staticParam.flag_false = "0";

staticParam.flag_true = "1";

// DEMO 请求路径
staticParam.action_reqPath_demo = "/ajax/ejx4tutdemo.action";
staticParam.action_reqPath_training = "/ajax/ejx4tuttraining.action"; //自己加的

