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
String filename = "E:\\IOtest\\Top20\\test_result\\getAcctInfo.txt";
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
public void jadgepara( Object[] para_arr )
{
	str1 = "Error:未返回字段---";
	str2 = "Error:字段返回错误---";
	
	for( m=0; m<1000; m++ )
	{
		if(para_arr[m][0] != null)
		{
			obj = para_arr[m][0];
			para = para_arr[m][1];
			item = para_arr[m][2];
			
			if(!obj.containsKey(para))
			{
				p.println( str1 + para + "--" + item );									//Error:未返回字段---xxx
				ass = true;
			}
			else
			{
				para_str = obj.get(para)+"";
				if((para_str == null) || (para_str.equals("-1")))
				{
					p.println( str2 + para + "--" + item );								//Error:字段返回错误---xxx
					ass = true;
				}
			}
		}
		else
		{
			break;
		}
	}
}

SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
p.println( "\n" );
p.println( "自动化测试开始，开始统计测试信息,当前的测试时间为：" +  df.format(new Date()) );
p.println( "-----------------------------------------------------" );
	
/*功能区*/
/* if(!List.containsKey("code"))										//错误码
{
	p.println( Errmessage_str + "code" );
	ass = true;
}
else
{
	code_str = List.get("code");
	if(!code_str.equals("0"))
	{
		p.println( "Error：接口返回失败，错误码：" + code_str );
		ass = true;
	}
} */
//功能点1:QQ
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("qq"))											
{
	p.println( Errmessage_str + "qq" );
	ass = true;
}else{
	 String qq_str = List.get("qq");
	if(qq_str == null)
	{
		p.println( "Error：qq字段为null，未登录qq" );
		ass = true;
	}else{
		p.println( "Pass：qq登录成功，登录的qq为：" + qq_str);
	}
} 
//功能点2: 登录状态
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
//功能点3:会员等级，对应红色标签
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
//功能点4:成长等级，对应绿色标签
// p.println( "第" + ++message_num + "个测试点如下：" );
// if(!List.containsKey("growLevel"))										
// {
	// p.println( Errmessage_str + "growLevel" );
	// ass = true;
// }else{
	// int growLevel_int = List.get("growLevel");
	// if(growLevel_int < 0)
	// {
		// p.println( "Error：growLevel字段返回错误" );
		// ass = true;
	// }else{
		// p.println( "Pass：登录的账号成长等级等级为：" + growLevel_int);
	// }
// }
//功能点5: 登录用户名称下面显示“累计阅读多少时间”
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("readTimeStr"))										
{
	p.println( Errmessage_str + "readTimeStr" );
	ass = true;
}
else{
	String readTimeStr_str = List.get("readTimeStr") + "";
	if(isLogin_str == "")
	{
		p.println( "Error：不显示阅读时间" );
		ass = true;
	}else{
		p.println( "pass：显示：" + readTimeStr_str );
	}
}

//功能点6:我的账户显示多少书币+多少书卷。
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("balance"))										
{
	p.println( Errmessage_str + "balance" );
	ass = true;
}else if(!List.containsKey("bookTicket"))										
	{
		p.println( Errmessage_str + "bookTicket" );
		ass = true;
	}else{
		 int balance_int = List.get("balance") ;
		 int bookTicket_int = List.get("bookTicket") ;
		if(balance_int < 0){
			p.println( "Error：balance 字段返回错误" );
			ass = true;
		}else if(bookTicket_int < 0){
			p.println( "Error：bookTicket 字段返回错误" );
			ass = true;
		}else{
			p.println( "Pass：我的账户显示：" + balance_int + "书币" + bookTicket_int + "书券" );
		}
	}

//功能点7:在我的账户下面显示，多少月票、多少推荐票、多少折扣券。
/* p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("icon"))										
{
	p.println( Errmessage_str + "icon" );
	ass = true;
}else{
	String icon_str =  List.get("icon") ;
	if(icon_str == null)
	{
		p.println( "Error：icon字段为null" );
		ass = true;
	}else{
		p.println( "Pass：icon字段为：" + icon_str);
	}
}
 */

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
