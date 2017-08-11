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
String filename = "E:\\IOtest\\Top20\\test_resultios\\getAcctInfo.txt";
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
//功能点1: 登录状态
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("isLogin"))										
{
	p.println( Errmessage_str + "isLogin" );
	ass = true;
}
else{
	String isLogin_str = List.get("isLogin") + "";
	if(isLogin_str == false)
	{
		p.println( "Error：登录状态为：未登录" );
		ass = true;
	}else{
		p.println( "Pass：登录状态为：正常登录");
	}
}
//功能点2:会员等级，对应红色标签
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("vipLevel"))										
{
	p.println( Errmessage_str + "vipLevel" );
	ass = true;
}else{
	int vipLevel_int = List.get("vipLevel");
	if(vipLevel_int < 0)
	{
		p.println( "Error：vipLevel字段返回错误" );
		ass = true;
	}else if(vipLevel_int == 0){
		p.println( "Pass：登录账号不是会员");
	}else{
		p.println( "Pass：登录账号为会员，登录的Vip等级为：" + vipLevel_int);
	}
}
//功能点3:成长等级，对应绿色标签
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("norLevel"))										
{
	p.println( Errmessage_str + "norLevel" );
	ass = true;
}else{
	int norLevel_int = List.get("norLevel");
	if(norLevel_int < 0)
	{
		p.println( "Error：growLevel字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：登录的账号成长等级等级为：" + norLevel_int);
	}
}
//功能点4:是否包月，对应icon显示中右下角的小书图标：
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("isMVip"))										
{
	p.println( Errmessage_str + "isMVip" );
	ass = true;
}else{
	boolean isPayMonth_boolean =  List.get("isMVip") ;
	p.println( "Pass：该用户" + ispaymonth.get(isPayMonth_boolean));
}
//功能点5: 登录用户名称下面显示“累计阅读多少时间”
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("readTimeStr"))										
{
	p.println( Errmessage_str + "readTimeStr" );
	ass = true;
}
else{
	String readTimeStr_str = List.get("readTimeStr") + "";
	if(isLogin_str.equals(""))
	{
		p.println( "Error：不显示阅读时间" );
		ass = true;
	}else{
		p.println( "pass：显示：" + readTimeStr_str );
	}
}

//功能点6:月票显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("leftMTicket"))										
{
	p.println( Errmessage_str + "leftMTicket" );
	ass = true;
	}else{
		int leftMTicket_int = List.get("leftMTicket") ;
		if(leftMTicket_int < 0){
			p.println( "Error：leftMTicket 字段返回错误" );
			}else{
				p.println( "Pass：月票显示：" + leftMTicket_int );
				}	
	}
//功能点7:推荐票显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("leftTicket"))										
{
	p.println( Errmessage_str + "leftTicket" );
	ass = true;
	}else{
		int vipComment_int = List.get("leftTicket") ;
		if(vipComment_int == null){
			p.println( "Error：leftTicket 字段返回错误" );
			}else{
				p.println( "Pass：推荐票显示：" + vipComment_int );
				}	
	}
//功能点8：抵扣券显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("combine"))										
{
	p.println( Errmessage_str + "combine" );
	ass = true;
}else{
	int combine_int = List.get("combine");
	if(combine_int < 0 )
	{
		p.println( "Error：combine字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：折扣券显示：" + combine_int);
	}
}
//功能点9：我的包月显示后显示：
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("vipComment")){
	p.println( Errmessage_str + "vipComment" );
	ss = true;
}else{
	String vipComment_str = List.get("vipComment") ;
	if(vipComment_str == null){
		p.println( "Error：vipComment 字段返回错误" );
	}else{
		p.println( "Pass：我的包月显示：" + vipComment_str );
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
