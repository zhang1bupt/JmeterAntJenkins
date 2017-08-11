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
String filename = "E:\\IOtest\\Top20\\test_result\\myaccount.txt";
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
				p.println( "Pass：余额显示：" + balance_int + "书币" );
				}	
	}
//功能点2:书卷显示。
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("bookTicket"))										
{
	p.println( Errmessage_str + "bookTicket" );
	ass = true;
	}else{
		 int bookTicket_int = List.get("bookTicket") ;
		 if(bookTicket_int < 0){
			p.println( "Error：bookTicket 字段返回错误" );
			ass = true;
		}else{
			p.println( "Pass：我的账户显示：" + bookTicket_int + "书券" );
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

//功能点:我的包月显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("vipComment"))										
{
	p.println( Errmessage_str + "vipComment" );
	ass = true;
	}else{
		String vipComment_str = List.get("vipComment") ;
		if(vipComment_str == null){
			p.println( "Error：vipComment 字段返回错误" );
			}else{
				p.println( "Pass：我的包月显示：" + vipComment_str );
				}	
	}
//功能点:月票显示
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
//功能点:我的包月体验卡
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("vipComment"))										
{
	p.println( Errmessage_str + "vipComment" );
	ass = true;
	}else{
		String vipComment_str = List.get("vipComment") ;
		if(vipComment_str == null){
			p.println( "Error：vipComment 字段返回错误" );
			}else{
				p.println( "Pass：我的包月显示：" + vipComment_str );
				}	
	}
//功能点:推荐票显示
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
//功能点3:登录昵称显示，最上部显示。
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("nickName"))										
{
	p.println( Errmessage_str + "nickName" );
	ass = true;
}else{
	nickname_str = List.get("nickName") + "";
	if(nickname_str == null)
	{
		p.println( "Error：nickname_str 字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：登录的昵称为：" + nickname_str);
	}
}
//功能点4:是否有"icon"字段
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("icon"))										
{
	p.println( Errmessage_str + "icon" );
	ass = true;
}else{
	String icon_str =  List.get("icon") ;
	if(icon_str == "")
	{
		p.println( "Error：icon字段为null" );
		ass = true;
	}else{
		p.println( "Pass：icon字段为：" + icon_str);
	}
}
//功能点5:是否包月，对应icon显示中右下角的小书图标：未找到对应字段
p.println( "第" + ++message_num + "个测试点如下：" );
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
//功能点6:成长等级，对应蓝色标签
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("gender"))										
{
	p.println( Errmessage_str + "gender" );
	ass = true;
}else{
	int gender_int =  List.get("gender") ;
	if(gender_int < 0)
	{
		p.println( "Error：gender字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：用户的性别为：" + sex.get(gender_int));
	}
}
//功能点7:会员等级，对应红色标签
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
//功能点8:成长等级，对应绿色标签
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("growLevel"))										
{
	p.println( Errmessage_str + "growLevel" );
	ass = true;
}else{
	int growLevel_int = List.get("growLevel");
	if(growLevel_int < 0)
	{
		p.println( "Error：growLevel字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：登录的账号成长等级等级为：" + growLevel_int);
	}
}
//功能点9:个性签名，在红色会员标签下显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("sign"))										
{
	p.println( Errmessage_str + "sign" );
	ass = true;
}else{
	String sign_str = List.get("sign");
	p.println( "Pass：个性签名显示为：" + sign_str);
	
}
//功能点10：阅读时长
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("readTime"))										
{
	p.println( Errmessage_str + "readTime" );
	ass = true;
}else{
	int readTime_int = List.get("readTime");
	if(readTime_int < 0)
	{
		p.println( "Error：readTime字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：阅读时长为：" + readTime_int/1000/60 + "分钟" );
	}
}
//功能点11：收到赞的个数
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("praiseNum"))										
{
	p.println( Errmessage_str + "praiseNum" );
	ass = true;
}else{
	int praiseNum_int = List.get("praiseNum");
	if(praiseNum_int < 0)
	{
		p.println( "Error：praiseNum字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：收到赞的个数为：" + praiseNum_int);
	}
}
//功能点12："我的等级"右部显示有多少成长值升级
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("upgradeValue"))										
{
	p.println( Errmessage_str + "upgradeValue" );
	ass = true;
}else{
	int upgradeValue_int = List.get("upgradeValue");
	if(upgradeValue_int < 0)
	{
		p.println( "Error：upgradeValue字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：显示-再有：" + upgradeValue_int + "成长值升级" );
	}
}
//功能点13：我的书架书的数量，在我的书架字下面显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("shelfCount"))										
{
	p.println( Errmessage_str + "shelfCount" );
	ass = true;
}else{
	int shelfCount_int = List.get("shelfCount");
	if(shelfCount_int < 0)
	{
		p.println( "Error：shelfCount字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：我的书架书的数量为：" + shelfCount_int);
	}
}
//功能点14：我的书架书的数量，在我的书架字下面显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("shelfCount"))										
{
	p.println( Errmessage_str + "shelfCount" );
	ass = true;
}else{
	int shelfCount_int = List.get("shelfCount");
	if(shelfCount_int < 0)
	{
		p.println( "Error：shelfCount字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：我的书架书的数量为：" + shelfCount_int);
	}
}
//功能点15：我的书架中具体书的显示：包括，书名，作者名，封面，
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("shelfList"))										
{
	p.println( Errmessage_str + "shelfList" );
	ass = true;
}else{
	shelfList_arr = List.get("shelfList");
	//p.println( List );
	//p.println( shelfList_list );
	if(shelfList_arr.size() == 0){
		p.println( "书架中不包含书" );
	}else{
		for( i=0; i < shelfList_arr.size(); i++ ){
			shelfList_list = shelfList_arr.get(i);
			p.println("\n");
			p.println( "**********我的书架************" );
			if(!shelfList_list.containsKey("bookCover")){
				p.println( "Error：bookCover字段返回错误" );
				ass = true;
			}else if( bookCover_str == null ){	
				p.println( "Error：书架中封面bookCover字段为空"  );
			}else{
				String bookCover_str = shelfList_list.get("bookCover");
				p.println( "Pass：书架中封面：" + bookCover_str );
			}
			if(!shelfList_list.containsKey("bookName")){
				p.println( "Error：bookName字段返回错误" );
				ass = true;
			}else if( bookName_str == null ){
				p.println( "Error：书架中书名字段为空"  );
			}else{
				String bookName_str =  shelfList_list.get("bookName");
				p.println( "Pass：书架中书名bookName：" + bookName_str);
			}
			if(!shelfList_list.containsKey("author")){
				p.println( "Error：author字段返回错误" );
				ass = true;
			}else if( author_str == null ){
				p.println( "Error：书架中作者author字段为空"  );
			}else{
				String author_str =  shelfList_list.get("author");
				p.println( "Pass：书架中作者：" + author_str );
			}
			p.println( "******************************" );
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
