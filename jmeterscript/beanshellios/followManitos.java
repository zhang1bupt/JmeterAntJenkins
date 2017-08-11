import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;  
import java.util.HashMap;  
try{
/* 输出打印文件信息流 ---> */
String filename = "E:\\IOtest\\Top20\\test_resultios\\followManitos.txt";
File file =new File(filename);
if(!file.exists())
{	
	file.createNewFile();
}
FileOutputStream fs = new FileOutputStream(file,false);//若true改为false，代表以覆盖的方式写入数据。
OutputStreamWriter out =new OutputStreamWriter(fs,"utf-8");//???? 代码中没看到用
PrintStream p = new PrintStream(fs);


/*封装类型*/

Map sex = new HashMap();  
sex.put(0, "男性");  
sex.put(1, "女性");  
Map ispaymonth = new HashMap();  
ispaymonth.put(true, "包月");  
ispaymonth.put(false, "未包月");  

int message_num = 0;
String jsonString = prev.getResponseDataAsString();			//获取json串,
JSONObject List = JSONValue.parse(jsonString);				//将获取json串赋给List

boolean ass = false;	//assert断言flg
/*常用逻辑函数化*/
String Errmessage_str = "Error:未返回字段：";
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
p.println( "\n" );
p.println( "自动化测试开始，开始统计测试信息,当前的测试时间为：" +  df.format(new Date()) );
p.println( "-----------------------------------------------------" );
	
/*功能区*/
//功能点1：关注的作家
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("followManitoList"))										
{
	p.println( Errmessage_str + "followManitoList" );
	ass = true;
}else{
    followManitoList_arr = List.get("followManitoList");
	if(followManitoList_arr.size() == 0){
		p.println( "暂无关注的作家" );
	}else{
		for( i=0; i < followManitoList_arr.size(); i++ ){
			followManito_list = followManitoList_arr.get(i);
			p.println("\n");
			p.println( "~~~~~~~~~~~~~关注的作家~~~~~~~~~~~~~~~~~" );
			//关注的作家子功能点1：图标显示
			if(!followManito_list.containsKey("icon")){
				p.println( "Error：icon字段返回错误" );
				ass = true;
			}else{
				String icon_str = followManito_list.get("icon");
				if(icon_str.equals("")){
					p.println( "Pass：没有作者的图标" );
				}else{
					p.println( "Pass：图标的地址为：" + icon_str );
				}
			}
			//关注的作家子功能点2：作者名称显示
			if(!followManito_list.containsKey("nickname")){
				p.println( "Error：nickname字段返回错误" );
				ass = true;
			}else{
				String nickname_str = followManito_list.get("nickname") ;
			   // String time="1256006105375";//long型转换成的字符串  
				if(nickname_str == ""){
					p.println( "Error：nickname字段返回为空" );
					ass = true;					
				}else{
					p.println( "Pass：第" + (i+1) + "个作者的名称为：" +  nickname_str );
				}	
			}
			//评论区子功能点：3 显示具体的互动内容
			if(!followManito_list.containsKey("desc")){
				p.println( "Error：message字段返回错误" );
				ass = true;
			}else{
				String desc_str = followManito_list.get("desc");
				if(desc_str.equals(" ")){
					p.println( "Pass：未对该作者做介绍" );
				}else{
					p.println( "Pass：第" + (i+1) + "个作者介绍显示为：" +  desc_str);
				}
				
			}
			p.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		}
	}
}	


if(ass)
{
	prev.setSuccessful(false);
	p.println( "\n" );
	p.println( "测试结束，当前时间为：" + df.format(new Date()) );
	p.println( "-----------------------------------------------------\n" );
}else{
	p.println( "\n" );
	p.println( "测试结束，当前时间为：" + df.format(new Date()) );
	p.println( "-----------------------------------------------------\n" );
}

p.close();
}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
