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
String filename = "E:\\IOtest\\Top20\\test_resultios\\privilege.txt";
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
//功能点1：用户包月类型（包月、年费、非包月）
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("monthStatus"))										
{
	p.println( Errmessage_str + "monthStatus" );
	ass = true;
}else{
	int monthStatus_int = List.get("monthStatus");
	if(monthStatus_int < -1 || monthStatus_int > 2)
	{
		p.println( "Error：monthStatus 字段返回错误" );
		ass = true;
	}else if(monthStatus_int == -1){
		p.println( "Pass：该用户未包月" );
	}else if(monthStatus_int == 1){
		p.println( "Pass：#####该用户为包月用户#####：" );
			//功能点2:图标是否有图
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("icon"))										
	{
		p.println( Errmessage_str + "icon" );
		ass = true;
		}else{
			String icon_str = List.get("icon") ;
			if(icon_str.equals("")){
				p.println( "Error：icon 账号没有图标显示" );
				ass = true;
				}else{
					p.println( "Pass：图标可以正常显示，图标的链接为：" + icon_str );
					}	
		}
	//功能点3:昵称显示。
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("nick"))										
	{
		p.println( Errmessage_str + "nick" );
		ass = true;
		}else{
			 String nick_str = List.get("nick") ;
			 if(nick_str.equals("")){
				p.println( "Error：昵称显示错误" );
				ass = true;
			}else{
				p.println( "Pass：昵称显示：" + nick_str  );
			}
		}
	//功能点4:包月到期时间显示显示
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("vipEndTime")){
		p.println( Errmessage_str + "vipEndTime" );
		ass = true;	
	}else{
		String vipEndTime_str = List.get("vipEndTime");
		if(vipEndTime_str.equals("")){
			p.println( "Error：vipEndTime 字段返回错误" );
		}else{
			p.println( "Pass：显示包月剩余时间：" + vipEndTime_str );
		}
	}

	//功能点5:身份持续时间
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("dayCount")){
		p.println( Errmessage_str + "dayCount" );
		ass = true;	
	}else{
		int dayCount_int = List.get("dayCount");
		if(dayCount_int < 0){
			p.println( "Error：vipEndTime 字段返回错误" );
		}else{
			p.println( "Pass：身份持续天数为：" + dayCount_int );
		}
	}
	//功能点6:包月书阅读数
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("readCount")){
		p.println( Errmessage_str + "readCount" );
		ass = true;	
	}else{
		int readCount_int = List.get("readCount");
		if(readCount_int < 0){
			p.println( "Error：vipEndTime 字段返回错误" );
		}else{
			p.println( "Pass：包月书阅读数为：" + readCount_int );
		}
	}
	//功能点7:特权节省阅点
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("saveCoin")){
		p.println( Errmessage_str + "saveCoin" );
		ass = true;	
	}else{
		int saveCoin_int = List.get("saveCoin");
		if(saveCoin_int < 0){
			p.println( "Error：vipEndTime 字段返回错误" );
		}else{
			p.println( "Pass：特权节省阅点为：" + saveCoin_int );
		}
	}
	}else if(monthStatus_int == 2){
		p.println( "Pass：#####该用户为包年用户#####：" );
			//功能点2:图标是否有图
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("icon"))										
	{
		p.println( Errmessage_str + "icon" );
		ass = true;
		}else{
			String icon_str = List.get("icon") ;
			if(icon_str.equals("")){
				p.println( "Error：icon 账号没有图标显示" );
				ass = true;
				}else{
					p.println( "Pass：图标可以正常显示，图标的链接为：" + icon_str );
					}	
		}
	//功能点3:昵称显示。
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("nick"))										
	{
		p.println( Errmessage_str + "nick" );
		ass = true;
		}else{
			 String nick_str = List.get("nick") ;
			 if(nick_str.equals("")){
				p.println( "Error：昵称显示错误" );
				ass = true;
			}else{
				p.println( "Pass：昵称显示：" + nick_str  );
			}
		}
	//功能点4:包月到期时间显示显示
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("vipEndTime")){
		p.println( Errmessage_str + "vipEndTime" );
		ass = true;	
	}else{
		String vipEndTime_str = List.get("vipEndTime");
		if(vipEndTime_str.equals("")){
			p.println( "Error：vipEndTime 字段返回错误" );
		}else{
			p.println( "Pass：显示包月剩余时间：" + vipEndTime_str );
		}
	}

	//功能点5:身份持续时间
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("dayCount")){
		p.println( Errmessage_str + "dayCount" );
		ass = true;	
	}else{
		int dayCount_int = List.get("dayCount");
		if(dayCount_int < 0){
			p.println( "Error：vipEndTime 字段返回错误" );
		}else{
			p.println( "Pass：身份持续天数为：" + dayCount_int );
		}
	}
	//功能点6:包月书阅读数
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("readCount")){
		p.println( Errmessage_str + "readCount" );
		ass = true;	
	}else{
		int readCount_int = List.get("readCount");
		if(readCount_int < 0){
			p.println( "Error：vipEndTime 字段返回错误" );
		}else{
			p.println( "Pass：包月书阅读数为：" + readCount_int );
		}
	}
	//功能点7:特权节省阅点
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!List.containsKey("saveCoin")){
		p.println( Errmessage_str + "saveCoin" );
		ass = true;	
	}else{
		int saveCoin_int = List.get("saveCoin");
		if(saveCoin_int < 0){
			p.println( "Error：vipEndTime 字段返回错误" );
		}else{
			p.println( "Pass：特权节省阅点为：" + saveCoin_int );
		}
	}
	}else{
		p.println( "Pass：该用户不懂什么用户,monthStatus对应的字段为：" + monthStatus_int );
	}
}

//功能点8:包月VIP每月专享礼包显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("giftRewardInfo"))										
{
	p.println( Errmessage_str + "giftRewardInfo" );
	ass = true;
	}else{
		String giftRewardInfo_str = List.get("giftRewardInfo") ;
		if(giftRewardInfo_str.equals("")){
			p.println( "Error：leftTicket 字段返回错误" );
			}else{
				p.println( "Pass：包月VIP每月专享礼包显示为：" + giftRewardInfo_str );
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
