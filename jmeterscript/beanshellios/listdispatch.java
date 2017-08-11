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
String filename = "E:\\IOtest\\Top20\\test_resultios\\listdispatch.txt";
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

if(!List.containsKey("infos"))										
{
	p.println( Errmessage_str + "infos" );
	ass = true;
}else{
    infos_arr = List.get("infos");
	if(infos_arr.size() == 0){
		p.println( "收藏为空" );
	}else{
		for( i=0; i < infos_arr.size(); i++ ){
			infos_list = infos_arr.get(i);
			p.println("\n");
			p.println( "##########我的收藏###########" );
			//我的收藏子功能点1：类型1： 标题、评论和图片
			int moudle_int = infos_list.get("moudle");
			if(	moudle_int == 1	){
				if(!infos_list.containsKey("info")){
					p.println( "Error：info字段返回错误" );
					ass = true;
				}else{
					info_list = infos_list.get("info");
					//标题显示：
					if(!info_list.containsKey("title")){
						p.println( Errmessage_str + "title" );
						ass = true;
					}else{
						String title_str = info_list.get("title");
						if(title_str.equals("")){
							p.println( "Error：标题为空" );
							ass = true;
						}else{
							p.println( "Pass：标题显示为：" + title_str );
						}
					}
					//标题下部显示
					if(!info_list.containsKey("desc")){
						p.println( Errmessage_str + "desc" );
						ass = true;
					}else{
						String desc_str = info_list.get("desc");
						if(desc_str.equals("")){
							p.println( "Error：标题下面显示为空" );
							ass = true;
						}else{
							p.println( "Pass：标题下面显示为：" + desc_str );
						}
					}
					//图片显示
					if(!info_list.containsKey("pics")){
						p.println( Errmessage_str + "pics" );
						ass = true;
					}else{
						pics_arr = info_list.get("pics");
						if(pics_arr.size() == 0){
							p.println( "Error：无图片链接地址" );
							ass = true;
						}else{
							String url_str = pics_arr.get(0).get("url");;
							p.println( "Pass：图片的链接地址为：" + url_str );
						}
					}	
				}
			}
			// 我的收藏子功能点2：类型2： 作者、书类型、内容和图片的显示
			if(	moudle_int == 3	){
				if(!infos_list.containsKey("info")){
					p.println( "Error：info字段返回错误" );
					ass = true;
				}else{
					info_list = infos_list.get("info");
					//作者显示：
					if(!info_list.containsKey("author")){
						p.println( Errmessage_str + "author" );
						ass = true;
					}else{
						String author_str = info_list.get("author");
						if(author_str.equals("")){
							p.println( "Error：作者为空" );
							//ass = true;
						}else{
							p.println( "Pass：作者显示为：" + author_str );
						}
					}
					//书的类型显示
					if(!info_list.containsKey("booktilte")){
						p.println( Errmessage_str + "booktilte" );
						ass = true;
					}else{
						String booktilte_str = info_list.get("booktilte");
						if(booktilte_str.equals("")){
							p.println( "Error：标题下面显示为空" );
							ass = true;
						}else{
							p.println( "Pass：标题下面显示为：" + booktilte_str );
						}
					}
					//书的类型显示
					if(!info_list.containsKey("content")){
						p.println( Errmessage_str + "content" );
						ass = true;
					}else{
						String content_str = info_list.get("content");
						if(content_str.equals("")){
							p.println( "Error：收藏书的内容显示为显示为空" );
							ass = true;
						}else{
							p.println( "Pass：标题下面显示为：" + content_str );
						}
					}
					//图片显示
					if(!info_list.containsKey("authorIcon")){
						p.println( Errmessage_str + "authorIcon" );
						ass = true;
					}else{
						String authorIcon_str = info_list.get("authorIcon");
						if(authorIcon_str.equals("")){
							p.println( "Error：无图片链接地址" );
							//ass = true;
						}else{
							p.println( "Pass：图片的链接地址为：" + authorIcon_str );
						}
					}
					//图片显示
					// if(!info_list.containsKey("pics")){
						// p.println( Errmessage_str + "pics" );
						// ass = true;
					// }else{
						// desc_arr = info_list.get("pics");
						// if(desc_str.size() == 0){
							// p.println( "Error：无图片链接地址" );
							// ass = true;
						// }else{
							// String url_str = desc_arr.get(0).get("url");;
							// p.println( "Pass：图片的链接地址为：" + url_str );
						// }
					// }	
				}
			}
			p.println( "############################" );
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
