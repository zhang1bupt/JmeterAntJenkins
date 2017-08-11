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
//精选_firstpage：五入口，今日必读，个性化运营栏目一，主编推荐，秒杀，个性化运营栏目二，猜你感兴趣
/* 输出打印文件信息流 ---> */
String filename = "E:\\IOtest\\Top20\\test_result\\firstpage.txt";
File file =new File(filename);
if(!file.exists())
{
	file.createNewFile();
}
FileOutputStream fs = new FileOutputStream(file,true);
OutputStreamWriter out =new OutputStreamWriter(fs,"UTF-8");
PrintStream p = new PrintStream(fs);
/* <--- 输出打印文件信息流 */

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

/*常用逻辑函数化*/

String jsonString = prev.getResponseDataAsString();					//获取json串
JSONObject List = JSONValue.parse(jsonString);						//将获取json串赋给List


/*基本信息*/
if(!List.containsKey("code"))										//错误码
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
}
if(!List.containsKey("qq"))											//qq
{
	p.println( Errmessage_str + "qq" );
	ass = true;
}
if(!List.containsKey("prefer"))										//偏好
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
else
{
	sex_l = List.get("sex");
	if(sex_l == -1)
	{
		p.println( "Error：sex字段返回错误" );
		ass = true;
	}
}
if(!List.containsKey("isVip"))										//会员状态
{
	p.println( Errmessage_str + "isVip" );
	ass = true;
}
else
{
	isVip_str = List.get("isVip") + "";
	if(isVip_str == null)
	{
		p.println( "Error：isVip字段返回错误" );
		ass = true;
	}
}
if(!List.containsKey("isLogin"))										//登录状态
{
	p.println( Errmessage_str + "isLogin" );
	ass = true;
}
else
{
	isLogin_str = List.get("isLogin") + "";
	if(isLogin_str == null)
	{
		p.println( "Error：isLogin字段返回错误" );
		ass = true;
	}
}

list_arr = List.get("list");

for( i=0; i<list_arr.size(); i++ )
{
	list_tmp = list_arr.get(i);
	style_l =  list_tmp.get("style");
	
	/*五入口*/
	if( style_l == 1 )
	{
		content_arr = list_tmp.get("content");
		for( j=0; j<content_arr.size(); j++ )
		{
			content_arr_obj = content_arr.get(j);
			
			Object[][] para_arr = 
			{
				{content_arr_obj,	"adid",			"五入口  "	},
				{content_arr_obj,	"fontcolor",	"五入口  "	},
				{content_arr_obj,	"icon",			"五入口  "	},
				{content_arr_obj,	"name",			"五入口  "	},
				{content_arr_obj,	"positionId",	"五入口  "	},
				{content_arr_obj,	"qurl",			"五入口  "	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);


			stat_params_obj =  content_arr_obj.get("stat_params");
			
			Object[][] para_arr = 
			{
				{stat_params_obj,	"alg",			"五入口  "	},
				{stat_params_obj,	"data_type",	"五入口  "	},
				{stat_params_obj,	"origin",		"五入口  "	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);
			
			

		}
	}
	/* 今日必读 */
	else if( style_l == 8 )
	{
		if( list_tmp.containsKey("content") )
		{
			content_obj = list_tmp.get("content");
			
			Object[][] para_arr = 
			{
				{content_obj,	"qurl",		"今日必读  "	},
				{content_obj,	"title",	"今日必读  "	},
				{null,				null,		null			},
			};
			jadgepara(para_arr);


			bookList_obj = content_obj.get("bookList");
			bookcount = bookList_obj.size();
			if(bookcount <= 5)
			{
				p.println( "Error：返回书籍数量小于5本，刷新不会变化(今日必读)" );
				ass = true;
			}
			for( j=0; j<bookList_obj.size(); j++ )
			{
				JSONObject bookList_obj_tmp = bookList_obj.get(j);
				
				Object[][] para_arr = 
				{
					{bookList_obj_tmp,	"title",	"今日必读  "	},
					{bookList_obj_tmp,	"bid",		"今日必读  "	},
					{bookList_obj_tmp,	"intro",	"今日必读  "	},
					{bookList_obj_tmp,	"author",	"今日必读  "	},
					{null,				null,		null			},
				};
				jadgepara(para_arr);
			}
		}
		else
		{
			p.println( "Error：没有返回书籍数据(今日必读)" );
			ass = true;
		}
	}
	/* 个性化运营栏目一 */
	else if( style_l == 5 )
	{
		if( list_tmp.containsKey("content") )
		{
			/* 专属推荐 */
			
			content_arr = list_tmp.get("content");
			content_arr_obj = content_arr.get(0);
			
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"专属推荐"	},
				{content_arr_obj,	"uistyle",		"专属推荐"	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);

			
			content_obj = content_arr_obj.get("content");
			if(!content_obj.containsKey("bids"))											//需要设置基因
			{
				Object[][] para_arr = 
				{
					{content_obj,	"qurl",		"专属推荐"	},
					{content_obj,	"time",		"专属推荐"	},
					{content_obj,	"title",	"专属推荐"	},
					{content_obj,	"desc",		"专属推荐"	},
					{null,			null,		null		},
				};
				jadgepara(para_arr);
			}
			else																			//不需要设置基因
			{
				Object[][] para_arr = 
				{
					{content_obj,	"qurl",		"专属推荐"	},
					{content_obj,	"time",		"专属推荐"	},
					{null,			null,		null		},
				};
				jadgepara(para_arr);
				
				bids_arr = content_obj.get("bids");											//展示书封(bid)
				bidsize_l = bids_arr.size();
				if(bidsize_l<=3)
				{
					p.println( "Error：数组bid长度小于3，刷新不会变化(个性化推荐)" );
					ass = true;
				}

				info_arr = content_obj.get("info");
				info_arr_obj = info_arr.get(0);
				
				Object[][] para_arr = 
				{
					{info_arr_obj,	"title",	"专属推荐"	},
					{info_arr_obj,	"desc",		"专属推荐"	},
					{null,			null,		null		},
				};
				jadgepara(para_arr);
			}
			/* 精品专场 */
			content_arr = list_tmp.get("content");
			content_arr_obj = content_arr.get(1);
			
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"精品专场"	},
				{content_arr_obj,	"uistyle",		"精品专场"	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);

			
			content_obj = content_arr_obj.get("content");
			bids_arr = content_obj.get("bids");
			bidsize_l = bids_arr.size();
			if(bidsize_l == 0 )
			{
				p.println( "Error：没有返回书籍,外露书封无法展示" );
				ass = true;
			}
			else if(bidsize_l <= 3 )
			{
				p.println( "Error：返回书籍数量小于3，刷新外露书封不变化(精品专场)" );
				ass = true;
			}
			
			Object[][] para_arr = 
			{
				{content_obj,	"qurl",	"精品专场"	},
				{null,			null,	null		},
			};
			jadgepara(para_arr);

			info_arr = content_obj.get("info");
			infosize_l = info_arr.size();
			if( infosize_l <= 1 )
			{
				p.println( "Error：返回样式小于1，刷新不变化(精品专场)" );
				ass = true;
			}
			for( j=0; j<info_arr.size(); j++ )
			{
				info_arr_obj = info_arr.get(j);
				Object[][] para_arr = 
				{
					{info_arr_obj,	"title",	"精品专场"	},
					{info_arr_obj,	"desc",		"精品专场"	},
					{null,			null,		null		},
				};
				jadgepara(para_arr);
			}
			/* 本周热搜/畅销/新书榜 */
			content_arr = list_tmp.get("content");
			content_arr_obj = content_arr.get(2);
			
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"本周热搜/畅销/新书榜"	},
				{content_arr_obj,	"uistyle",		"本周热搜/畅销/新书榜"	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);

			content_arr_obj_arr = content_arr_obj.get("content");
			for( j=0; j<content_arr_obj_arr.size(); j++ )
			{
				content_arr_obj_arr_obj = content_arr_obj_arr.get(j);

				Object[][] para_arr = 
				{
					{content_arr_obj_arr_obj,	"qurl",	"本周热搜/畅销/新书榜"	},
					{content_arr_obj_arr_obj,	"title","本周热搜/畅销/新书榜"	},
					{content_arr_obj_arr_obj,	"desc",	"本周热搜/畅销/新书榜"	},
					{null,						null,	null		},
				};
				jadgepara(para_arr);
			}
			
			/* 影视原著 */
			content_arr = list_tmp.get("content");
			content_arr_obj = content_arr.get(3);

			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"影视原著"	},
				{content_arr_obj,	"uistyle",		"影视原著"	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);


			content_arr_obj_arr = content_arr_obj.get("content");
			for( j=0; j<content_arr_obj_arr.size(); j++ )
			{
				content_arr_obj_arr_obj = content_arr_obj_arr.get(j);
				
				Object[][] para_arr = 
				{
					{content_arr_obj_arr_obj,	"image",	"影视原著"	},
					{content_arr_obj_arr_obj,	"qurl",		"影视原著"	},
					{content_arr_obj_arr_obj,	"title",	"影视原著"	},
					{content_arr_obj_arr_obj,	"desc",		"影视原著"	},
					{null,				null,		null		},
				};
				jadgepara(para_arr);
			}
		}
		else
		{
			p.println( "Error：个性化栏目一没有返回数据" );
			ass = true;
		}
	}
	/* 主编推荐 */
	else if( style_l == 9 )
	{
		content_arr = list_tmp.get("content");

		for( j=0; j<content_arr.size(); j++ )
		{
			content_arr_obj = content_arr.get(j);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"image",		"主编推荐"	},
				{content_arr_obj,	"preference",	"主编推荐"	},
				{content_arr_obj,	"qurl",			"主编推荐"	},
				{content_arr_obj,	"title",		"主编推荐"	},
				{content_arr_obj,	"pushName",		"主编推荐"	},
				{content_arr_obj,	"desc",			"主编推荐"	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);
		
			bookList_arr = content_arr_obj.get("bookList");
			bookList_arr_obj = bookList_arr.get(0);
			Object[][] para_arr = 
			{
				{bookList_arr_obj,	"catel3name",		"主编推荐"	},
				{bookList_arr_obj,	"totalWords",		"主编推荐"	},
				{bookList_arr_obj,	"author",			"主编推荐"	},
				{bookList_arr_obj,	"cpushName",		"主编推荐"	},
				{bookList_arr_obj,	"exquisite",		"主编推荐"	},
				{bookList_arr_obj,	"finished",			"主编推荐"	},
				{bookList_arr_obj,	"updateTime",		"主编推荐"	},
				{bookList_arr_obj,	"title",			"主编推荐"	},
				{bookList_arr_obj,	"categoryName",		"主编推荐"	},
				{bookList_arr_obj,	"lastChapter",		"主编推荐"	},
				{bookList_arr_obj,	"unitprice",		"主编推荐"	},
				{bookList_arr_obj,	"catel2name",		"主编推荐"	},
				{bookList_arr_obj,	"form",				"主编推荐"	},
				{bookList_arr_obj,	"price",			"主编推荐"	},
				{bookList_arr_obj,	"intro",			"主编推荐"	},
				{bookList_arr_obj,	"bid",				"主编推荐"	},
				{null,				null,				null		},
			};
			jadgepara(para_arr);
		}
	}
	/* 今日秒杀 */
	else if( style_l == 13 )
	{
		content_obj = list_tmp.get("content");
		
		Object[][] para_arr = 
		{
			{content_obj,	"currentTime",	"今日秒杀"	},
			{content_obj,	"endTime",		"今日秒杀"	},
			{content_obj,	"qurl",			"今日秒杀"	},
			{content_obj,	"title",		"今日秒杀"	},
			{content_obj,	"pushName",		"今日秒杀"	},
			{content_obj,	"desc",			"今日秒杀"	},
			{null,			null,			null		},
		};
		jadgepara(para_arr);

		bookList_arr = content_obj.get("bookList");
		for( j=0; j<bookList_arr.size(); j++ )
		{
			bookList_arr_obj = bookList_arr.get(j);
			Object[][] para_arr = 
			{
				{bookList_arr_obj,	"originalPrice",	"今日秒杀"	},
				{bookList_arr_obj,	"discountPrice",	"今日秒杀"	},
				{bookList_arr_obj,	"bid",				"今日秒杀"	},
				{bookList_arr_obj,	"title",			"今日秒杀"	},
				{null,				null,				null		},
			};
			jadgepara(para_arr);
		}
	}
	/* 个性化栏目二 */
	else if( style_l == 6 )
	{
		if( list_tmp.containsKey("content") )
		{
			content_arr = list_tmp.get("content");
			
			/* 大神 */
			content_arr_obj = content_arr.get(0);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"个性化栏目二---大神"	},
				{content_arr_obj,	"uistyle",		"个性化栏目二---大神"	},
				{null,				null,			null					},
			};
			jadgepara(para_arr);
			
			content_arr_obj_arr = content_arr_obj.get("content");
			for( j=0; j<content_arr_obj_arr.size(); j++ )
			{
				content_arr_obj = content_arr_obj_arr.get(j);
				Object[][] para_arr = 
				{
					{content_arr_obj,	"image",	"个性化栏目二---大神"	},
					{content_arr_obj,	"qurl",		"个性化栏目二---大神"	},
					{content_arr_obj,	"title",	"个性化栏目二---大神"	},
					{content_arr_obj,	"desc",		"个性化栏目二---大神"	},
					{null,				null,		null					},
				};
				jadgepara(para_arr);
			}

			/* 限免ing */
			content_arr_obj = content_arr.get(1);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"个性化栏目二---限免ing  "	},
				{content_arr_obj,	"uistyle",		"个性化栏目二---限免ing  "	},
				{null,				null,			null						},
			};
			jadgepara(para_arr);
			content_arr_obj_obj = content_arr_obj.get("content");
			Object[][] para_arr = 
			{
				{content_arr_obj_obj,	"bids",	"个性化栏目二---限免ing  "	},
				{content_arr_obj_obj,	"qurl",	"个性化栏目二---限免ing  "	},
				{null,				null,	null					},
			};
			jadgepara(para_arr);
			info_arr = content_arr_obj_obj.get("info");
			for( j=0; j<info_arr.size(); j++ )
			{
				info_arr_obj = info_arr.get(j);
				Object[][] para_arr = 
				{
					{info_arr_obj,	"title",	"个性化栏目二---限免ing---info[]:"	},
					{info_arr_obj,	"desc",		"个性化栏目二---限免ing---info[]:"	},
					{null,			null,		null					},
				};
				jadgepara(para_arr);
			}
			
			/* 今日特价 */
			content_arr_obj = content_arr.get(2);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"个性化栏目二---今日特价  "	},
				{content_arr_obj,	"uistyle",		"个性化栏目二---今日特价  "	},
				{null,				null,			null						},
			};
			jadgepara(para_arr);
			
			content_arr_obj_obj = content_arr_obj.get("content");
			Object[][] para_arr = 
			{
				{content_arr_obj_obj,	"bids",	"个性化栏目二---今日特价  "	},
				{content_arr_obj_obj,	"qurl",	"个性化栏目二---今日特价  "	},
				{null,				null,	null					},
			};
			jadgepara(para_arr);
			
			info_arr = content_arr_obj_obj.get("info");
			for( j=0; j<info_arr.size(); j++ )
			{
				info_arr_obj = info_arr.get(j);
				Object[][] para_arr = 
				{
					{info_arr_obj,	"title",	"个性化栏目二---今日特价---info[]:"	},
					{info_arr_obj,	"desc",		"个性化栏目二---今日特价---info[]:"	},
					{null,			null,		null					},
				};
				jadgepara(para_arr);
			}
			
			/* 包月专区 */
			content_arr_obj = content_arr.get(3);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"个性化栏目二---包月专区  "	},
				{content_arr_obj,	"uistyle",		"个性化栏目二---包月专区  "	},
				{null,				null,			null						},
			};
			jadgepara(para_arr);
			
			content_arr_obj_arr = content_arr_obj.get("content");
			content_arr_obj_arr_obj = content_arr_obj_arr.get(0);
			Object[][] para_arr = 
			{
				{content_arr_obj_arr_obj,	"image",	"个性化栏目二---包月专区  "	},
				{content_arr_obj_arr_obj,	"qurl",		"个性化栏目二---包月专区  "	},
				{content_arr_obj_arr_obj,	"title",	"个性化栏目二---包月专区  "	},
				{content_arr_obj_arr_obj,	"desc",		"个性化栏目二---包月专区  "	},
				{null,						null,		null					},
			};
			jadgepara(para_arr);
			
			/* 听书专区 */
			content_arr_obj = content_arr.get(4);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"个性化栏目二---听书专区  "	},
				{content_arr_obj,	"uistyle",		"个性化栏目二---听书专区  "	},
				{null,				null,			null						},
			};
			jadgepara(para_arr);
			
			content_arr_obj_arr = content_arr_obj.get("content");
			content_arr_obj_arr_obj = content_arr_obj_arr.get(0);
			Object[][] para_arr = 
			{
				{content_arr_obj_arr_obj,	"image",	"个性化栏目二---听书专区  "	},
				{content_arr_obj_arr_obj,	"qurl",		"个性化栏目二---听书专区  "	},
				{content_arr_obj_arr_obj,	"title",	"个性化栏目二---听书专区  "	},
				{content_arr_obj_arr_obj,	"desc",		"个性化栏目二---听书专区  "	},
				{null,						null,		null					},
			};
			jadgepara(para_arr);
		}
		else
		{
			p.println( "Error：个性化栏目二没有返回数据" );
			ass = true;
		}
	}
	/* 猜你感兴趣 */
	else if( style_l == 7 )
	{
		if( list_tmp.containsKey("content") )
		{
			content_arr = list_tmp.get("content");
			
			for( j=0; j<content_arr.size(); j++ )
			{
				content_arr_obj = content_arr.get(j);
            
				Object[][] para_arr = 
				{
					{content_arr_obj,	"bookNum",	"猜你感兴趣  "	},
					{content_arr_obj,	"bids",		"猜你感兴趣  "	},
					{content_arr_obj,	"qurl",		"猜你感兴趣  "	},
					{content_arr_obj,	"catename",	"猜你感兴趣  "	},
					{null,				null,		null			},
				};
				jadgepara(para_arr);
				
				bids_arr = content_arr_obj.get("bids");
				bids_size_l = bids_arr.size();
				if(bids_size_l < 3)
				{
					p.println( "Error：猜你感兴趣返回bid数目小于3" );
					ass = true;
				}
			}
		}
		else
		{
			p.println( "Error：猜你感兴趣没有返回数据" );
			ass = true;
		}
	}

}


p.close();
}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
