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
String filename = "E:\\IOtest\\Top20\\test_resultios\\queryselectedtag.txt";
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
//功能点1:我的收藏显示
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("tags"))										
{
	p.println( Errmessage_str + "tags" );
	ass = true;
}else{
    tags_arr = List.get("tags");
	if(tags_arr.size() == 0){
		p.println( "未添加基因" );
	}else{
		for( i=0; i < tags_arr.size(); i++ ){
			tags_list = tags_arr.get(i);
			p.println("\n");
			p.println( "##########基因###########" );
			if(!tags_list.containsKey("extInfo")){
				p.println( "Error：extInfo字段返回错误" );
				ass = true;
			}else{
				extInfo_list = tags_list.get("extInfo");
				//子功能点1：基因类型显示：
				if(!extInfo_list.containsKey("fullname")){
					p.println( Errmessage_str + "fullname" );
					ass = true;
				}else{
					String fullname_str = extInfo_list.get("fullname");
					if(fullname_str.equals("")){
						p.println( "Error：当前类型基因字段位空" );
						ass = true;
					}else{
						p.println( "Pass：基因类型显示为：" + fullname_str );
					}
				}
				//子功能点2：基因所占比例
				if(!extInfo_list.containsKey("wpercent")){
					p.println( Errmessage_str + "wpercent" );
					ass = true;
				}else{
					String wpercent_str = extInfo_list.get("wpercent");
					if(wpercent_str.equals("")){
						p.println( "Error：标题下面显示为空" );
						ass = true;
					}else{
						p.println( "Pass：该条基因所占比例显示为：" + wpercent_str );
					}
				}
			}
		}	
		p.println( "############################" );
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
