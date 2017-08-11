import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
try{
/* 输出打印文件信息流 ---> */
String filename = "E:\\IOtest\\Top20\\test_result\\lanchtest.txt";
File file =new File(filename);
if(!file.exists())
{
	file.createNewFile();
}
FileOutputStream fs = new FileOutputStream(file,true);//若true改为false，代表以覆盖的方式写入数据。
OutputStreamWriter out =new OutputStreamWriter(fs,"utf-8");//???? 代码中没看到用
PrintStream p = new PrintStream(fs);
p.println( "\n" );
p.println( "自动化测试开始，开始统计测试信息" );
p.println( "-----------------------------------------------------" );

int message_num = 0;
String jsonString = prev.getResponseDataAsString();			//获取json串,
JSONObject List = JSONValue.parse(jsonString);				//将获取json串赋给List



boolean ass = false;	//assert断言flg
String Errmessage_str = "Error:未返回字段：";
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


	


p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("qq"))											//qq
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
/* if(!List.containsKey("prefer"))										//偏好
{
	p.println( Errmessage_str + "prefer" );
	ass = true;
}
else
{
	prefer_l = List.get("prefer");
	if(prefer_l == -1)
	{
		p.println( "Error：prefer字段返回错误" );
		ass = true;
	}
}
if(!List.containsKey("sex"))										//性别
{
	p.println( Errmessage_str + "sex" );
	ass = true;
}
else{
	sex_l = List.get("sex");
	if(sex_l == -1)
	{
		p.println( "Error：sex字段返回错误" );
		ass = true;
	}
} */
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("isVip"))										//会员状态
{
	p.println( Errmessage_str + "isVip" );
	ass = true;
}else{
	isVip_str = List.get("isVip") + "";
	if(isVip_str == null)
	{
		p.println( "Error：isVip字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：登录账号为会员，登录的Vip等级为：" + isVip_str);
	}
}

p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("isLogin"))										//登录状态
{
	p.println( Errmessage_str + "isLogin" );
	ass = true;
}
else{
	isLogin_str = List.get("isLogin") + "";
	if(isLogin_str == null)
	{
		p.println( "Error：isLogin字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：True表示正常登录，False表示未登录，登录状态为" + isLogin_str);
	}
}
if(ass)
{
  prev.setSuccessful(false);
  p.println( "-----------------------------------------------------\n" );
}

p.close();
}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
