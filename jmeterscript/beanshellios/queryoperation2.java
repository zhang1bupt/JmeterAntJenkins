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
String filename = "E:\\IOtest\\Top20\\test_resultios\\queryoperation2.txt";
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
ispaymonth.put(1, "包月");  
ispaymonth.put(0, "未包月");  
Map status_map = new HashMap();  
status_map.put(1, "已回答");  
status_map.put(2, "已过期");  
Map vipstatus_map = new HashMap();  
vipstatus_map.put(1, "包月");  
vipstatus_map.put(2, "包年");  
vipstatus_map.put(0, "未包月"); 
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
	
//功能点1:QQ
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("qq"))											
{
	p.println( Errmessage_str + "qq" );
	ass = true;
}else{
	 long qq_int = List.get("qq");
	if(qq_int == -1)
	{
		p.println( "Error：qq字段为-1，未登录qq" );
		ass = true;
	}else{
		p.println( "Pass：qq登录成功，登录的qq为：" + qq_int);
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
/* //功能点3：最上面广告显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("ads"))										
{
	p.println( Errmessage_str + "ads" );
	ass = true;
}else{
    ads_list = List.get("ads");
	if(!ads_list.containsKey("103283"))//103282代表男频，103283代表女频~								
	{
		p.println( Errmessage_str + "103283" );
		ass = true;
	}
	cid103283_list = ads_list.get("103283");
	if(!cid103283_list.containsKey("adList"))
	{
		p.println( "Error：界面最上部不包含浮动广告" );
		ass = true;
	}else{
		adList_arr = cid103283_list.get("adList");
		if(adList_arr.size() == 0)
		{
			p.println( "Error：界面最上部不包含浮动广告" );
			ass = true;
		}else{
			for(int i = 0;i < adList_arr.size();i++){
				p.println( "\n" );
				p.println("**************浮动广告显示**************");
				adList_list = adList_arr.get(i);
				//广告名称显示：
				if(!adList_list.containsKey("title"))										
				{
					p.println( Errmessage_str + "title" );
					ass = true;
				}
				else{
					String title_str = adList_list.get("title") + "";
					if(title_str.equals("") )
					{
						p.println( "Error：标题内容为空" );
						ass = true;
					}else{
						p.println( "Pass：标题显示为：" + title_str);
					}
				}
				//浮动广告图片地址显示：
				if(!adList_list.containsKey("imageUrl"))										
				{
					p.println( Errmessage_str + "imageUrl" );
					ass = true;
				}
				else{
					String imageUrl_str = adList_list.get("imageUrl");
					if(imageUrl_str.equals("") )
					{
						p.println( "Error：标题内容为空" );
						ass = true;
					}else{
						p.println( "Pass：图片地址链接显示为：" + imageUrl_str);
					}
				}
				p.println("***********************************");
			}
		}
	}
} */
//功能点4：瀑布式免费类型，有两种类型显示，带图和不带图，分别在cols和jzqmCols中
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("cols"))										
{
	p.println( Errmessage_str + "cols" );
	ass = true;
}else{
    cols_list = List.get("cols");
	if(!cols_list.containsKey("10641"))//cid = 10647（男），10655（女），10641 （出版）代表对应免费类型为今日免费~										
	{
		p.println( Errmessage_str + "10641" );
		ass = true;
	}else{
		cid10641_list = cols_list.get("10641");
		//模块名称显示
		if(!cid10641_list.containsKey("title")){
			p.println( Errmessage_str + "title" );
			ass = true;
		}else{
			title1_str = cid10641_list.get("title");
			p.println( "Pass：模块名称显示为：" + title1_str);
		}
		if(!cid10641_list.containsKey("bookList"))										
		{
			p.println( Errmessage_str + "bookList" );
			ass = true;
		}else{
			bookList_arr = cid10641_list.get("bookList");
			for(int i = 0;i < bookList_arr.size();i++){
				p.println( "\n" );
				p.println("**************— 今日免费书 —**************");
				bookList_list = bookList_arr.get(i);
				//书作者
				if(!bookList_list.containsKey("author"))									
				{
					p.println( Errmessage_str + "author" );
					ass = true;
				}else{
					author_str = bookList_list.get("author");
					p.println( "Pass：书的作者显示为：" + author_str);
				}
				//书名
				if(!bookList_list.containsKey("title"))									
				{
					p.println( Errmessage_str + "title" );
					ass = true;
				}else{
					title_str = bookList_list.get("title");
					p.println( "Pass：书名显示为：" + title_str);
				}
				//原价显示
				if(!bookList_list.containsKey("originalPrice"))									
				{
					p.println( Errmessage_str + "originalPrice" );
					ass = true;
				}else{
					originalPrice_str = bookList_list.get("originalPrice");
					p.println( "Pass：书的原价显示为：" + originalPrice_str);
				}
				//折扣价显示
				if(!bookList_list.containsKey("discountPrice"))									
				{
					p.println( Errmessage_str + "discountPrice" );
					ass = true;
				}else{
					discountPrice_str = bookList_list.get("discountPrice");
					p.println( "Pass：书的折扣价显示为：" + discountPrice_str);
				}
				//介绍显示
				if(!bookList_list.containsKey("intro"))									
				{
					p.println( Errmessage_str + "intro" );
					ass = true;
				}else{
					intro_str = bookList_list.get("intro");
					p.println( "Pass：介绍显示为：" + intro_str);
				}
				//字数显示
				if(!bookList_list.containsKey("totalWords"))									
				{
					p.println( Errmessage_str + "totalWords" );
					ass = true;
				}else{
					totalWords_str = bookList_list.get("totalWords");
					p.println( "Pass：字数显示为：" + totalWords_str);
				}
				//书籍属性显示
				if(!bookList_list.containsKey("catel2name"))									
				{
					p.println( Errmessage_str + "catel2name" );
					ass = true;
				}else{
					catel2name_str = bookList_list.get("catel2name");
					p.println( "Pass：介绍显示为：" + catel2name_str);
				}
				p.println("*********************************");
			}
		}
	}
	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!cols_list.containsKey("10644"))//cid = 10647（男），10655（女），10644 （出版）代表对应免费类型为爆款限免~										
	{
		p.println( Errmessage_str + "10644" );
		ass = true;
	}else{
		cid10644_list = cols_list.get("10644");
		//模块名称显示
		if(!cid10644_list.containsKey("title")){
			p.println( Errmessage_str + "title" );
			ass = true;
		}else{
			title1_str = cid10644_list.get("title");
			p.println( "Pass：模块名称显示为：" + title1_str);
		}
		if(!cid10644_list.containsKey("bookList"))										
		{
			p.println( Errmessage_str + "bookList" );
			ass = true;
		}else{
			bookList_arr = cid10644_list.get("bookList");
			for(int i = 0;i < bookList_arr.size();i++){
				p.println( "\n" );
				p.println("**************— 公版免费书 —**************");
				bookList_list = bookList_arr.get(i);
				//书作者
				if(!bookList_list.containsKey("author"))									
				{
					p.println( Errmessage_str + "author" );
					ass = true;
				}else{
					author_str = bookList_list.get("author");
					p.println( "Pass：书的作者显示为：" + author_str);
				}
				//书名
				if(!bookList_list.containsKey("title"))									
				{
					p.println( Errmessage_str + "title" );
					ass = true;
				}else{
					title_str = bookList_list.get("title");
					p.println( "Pass：书名显示为：" + title_str);
				}
				//原价显示
				if(!bookList_list.containsKey("originalPrice"))									
				{
					p.println( Errmessage_str + "originalPrice" );
					ass = true;
				}else{
					originalPrice_str = bookList_list.get("originalPrice");
					p.println( "Pass：书的原价显示为：" + originalPrice_str);
				}
				//折扣价显示
				if(!bookList_list.containsKey("discountPrice"))									
				{
					p.println( Errmessage_str + "discountPrice" );
					ass = true;
				}else{
					discountPrice_str = bookList_list.get("discountPrice");
					p.println( "Pass：书的折扣价显示为：" + discountPrice_str);
				}
				//介绍显示
				if(!bookList_list.containsKey("intro"))									
				{
					p.println( Errmessage_str + "intro" );
					ass = true;
				}else{
					intro_str = bookList_list.get("intro");
					p.println( "Pass：介绍显示为：" + intro_str);
				}
				//字数显示
				if(!bookList_list.containsKey("totalWords"))									
				{
					p.println( Errmessage_str + "totalWords" );
					ass = true;
				}else{
					totalWords_str = bookList_list.get("totalWords");
					p.println( "Pass：字数显示为：" + totalWords_str);
				}
				//书籍属性显示
				if(!bookList_list.containsKey("catel2name"))									
				{
					p.println( Errmessage_str + "catel2name" );
					ass = true;
				}else{
					catel2name_str = bookList_list.get("catel2name");
					p.println( "Pass：介绍显示为：" + catel2name_str);
				}
				p.println("*********************************");
			}
		}
	}

	p.println( "第" + ++message_num + "个测试点如下：" );
	if(!cols_list.containsKey("10642"))//cid = 2044，2049（女）,10642(出版) 对应免费类型为免费新书~										
	{
		p.println( Errmessage_str + "10642" );
		ass = true;
	}else{
		cid10642_list = cols_list.get("10642");
		//模块名称显示
		if(!cid10642_list.containsKey("title")){
			p.println( Errmessage_str + "title" );
			ass = true;
		}else{
			title1_str = cid10642_list.get("title");
			p.println( "Pass：模块名称显示为：" + title1_str);
		}
		if(!cid10642_list.containsKey("bookList"))										
		{
			p.println( Errmessage_str + "bookList" );
			ass = true;
		}else{
			bookList_arr = cid10642_list.get("bookList");
			for(int i = 0;i < bookList_arr.size();i++){
				p.println( "\n" );
				p.println("**************— 免费新书 —**************");
				bookList_list = bookList_arr.get(i);
				//书作者
				if(!bookList_list.containsKey("author"))									
				{
					p.println( Errmessage_str + "author" );
					ass = true;
				}else{
					author_str = bookList_list.get("author");
					p.println( "Pass：书的作者显示为：" + author_str);
				}
				//书名
				if(!bookList_list.containsKey("title"))									
				{
					p.println( Errmessage_str + "title" );
					ass = true;
				}else{
					title_str = bookList_list.get("title");
					p.println( "Pass：书名显示为：" + title_str);
				}
				//原价显示
				if(!bookList_list.containsKey("originalPrice"))									
				{
					p.println( Errmessage_str + "originalPrice" );
					ass = true;
				}else{
					originalPrice_str = bookList_list.get("originalPrice");
					p.println( "Pass：书的原价显示为：" + originalPrice_str);
				}
				//折扣价显示
				if(!bookList_list.containsKey("discountPrice"))									
				{
					p.println( Errmessage_str + "discountPrice" );
					ass = true;
				}else{
					discountPrice_str = bookList_list.get("discountPrice");
					p.println( "Pass：书的折扣价显示为：" + discountPrice_str);
				}
				//介绍显示
				if(!bookList_list.containsKey("intro"))									
				{
					p.println( Errmessage_str + "intro" );
					ass = true;
				}else{
					intro_str = bookList_list.get("intro");
					p.println( "Pass：介绍显示为：" + intro_str);
				}
				//字数显示
				if(!bookList_list.containsKey("totalWords"))									
				{
					p.println( Errmessage_str + "totalWords" );
					ass = true;
				}else{
					totalWords_str = bookList_list.get("totalWords");
					p.println( "Pass：介绍显示为：" + totalWords_str);
				}
				//书籍属性显示
				if(!bookList_list.containsKey("catel2name"))									
				{
					p.println( Errmessage_str + "catel2name" );
					ass = true;
				}else{
					catel2name_str = bookList_list.get("catel2name");
					p.println( "Pass：介绍显示为：" + catel2name_str);
				}
				p.println("**********************************");
			}
		}
	}
}
	//最下部集赞求免
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("jzqmCols")){
	p.println( Errmessage_str + "2056" );
	ass = true;
}else{
	jzqmCols_list = List.get("jzqmCols");
	if(!jzqmCols_list.containsKey("2056"))//cid = 2053，2052（女），2057（出版） 代表对应免费类型为集赞求免~										
	{
		p.println( Errmessage_str + "2056" );
		ass = true;
	}else{
		cid2056_list = jzqmCols_list.get("2056");
		if(!cid2056_list.containsKey("title")){
			p.println( Errmessage_str + "title" );
			ass = true;
		}else{
			title1_str = cid2056_list.get("title");
			p.println( "Pass：模块名称显示为：" + title1_str);
		}
		if(!cid2056_list.containsKey("bookList"))										
		{
			p.println( Errmessage_str + "bookList" );
			ass = true;
		}else{
			bookList_arr = cid2056_list.get("bookList");
			for(int i = 0;i < bookList_arr.size();i++){
				p.println( "\n" );
				p.println("**************— 集赞求免 —**************");
				bookList_list = bookList_arr.get(i);
				//书名
				if(!bookList_list.containsKey("title"))									
				{
					p.println( Errmessage_str + "title" );
					ass = true;
				}else{
					title_str = bookList_list.get("title");
					p.println( "Pass：书名显示为：" + title_str);
				}
				//集赞数量显示
				if(!bookList_list.containsKey("jzcount"))									
				{
					p.println( Errmessage_str + "jzcount" );
					ass = true;
				}else{
					jzcount_str = bookList_list.get("jzcount");
					p.println( "Pass：集赞数量显示为：" + jzcount_str );
				}				
				p.println("*********************************");
			}
		}	
	}
}
SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式	
if(ass)
{
	prev.setSuccessful(false);
	p.println( "\n" );
	p.println( "测试结束，当前时间为：" + df1.format(new Date()) );
	p.println( "-----------------------------------------------------\n" );
}else{
	p.println( "\n" );
	p.println( "测试结束，当前时间为：" + df1.format(new Date()) );
	p.println( "-----------------------------------------------------\n" );
}

p.close();
}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
