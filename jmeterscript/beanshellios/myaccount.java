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
String filename = "E:\\IOtest\\Top20\\test_resultios\\myaccount.txt";
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
//功能点1:余额显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("balance"))										
{
	p.println( Errmessage_str + "balance" );
	ass = true;
	}else{
		int balance_int = List.get("balance") ;
		if(balance_int < 0){
			p.println( "Error：balance 字段返回错误" );
			}else{
				p.println( "Pass：余额显示：" + balance_int + "阅点" );
				}	
	}
//功能点2:阅卷显示。
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("gen_balance"))										
{
	p.println( Errmessage_str + "gen_balance" );
	ass = true;
	}else{
		 int gen_balance_int = List.get("gen_balance") ;
		 if(gen_balance_int < 0){
			p.println( "Error：bookTicket 字段返回错误" );
			ass = true;
		}else{
			p.println( "Pass：我的阅券显示：" + gen_balance_int  );
		}
	}
//功能点3：抵扣券显示
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

//功能点4:我的包月显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("monthUser")){
	p.println( Errmessage_str + "monthUser" );
	ass = true;	
}else{
	monthUser_list = List.get("monthUser");
	if(!monthUser_list.containsKey("vipComment")){
		p.println( Errmessage_str + "vipComment" );
			ass = true;
	}else{
		String vipComment_str = monthUser_list.get("vipComment") ;
		if(vipComment_str.equals("")){
			p.println( "Error：vipComment 字段返回错误" );
		}else{
			p.println( "Pass：我的包月显示：" + vipComment_str );
		}
	}
} 

//功能点5:推荐票显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("leftTicket"))										
{
	p.println( Errmessage_str + "leftTicket" );
	ass = true;
	}else{
		int vipComment_int = List.get("leftTicket") ;
		if(vipComment_int.equals("")){
			p.println( "Error：leftTicket 字段返回错误" );
			}else{
				p.println( "Pass：推荐票显示：" + vipComment_int );
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
