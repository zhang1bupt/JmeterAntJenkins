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
//��ѡ_firstpage������ڣ����ձض������Ի���Ӫ��Ŀһ�������Ƽ�����ɱ�����Ի���Ӫ��Ŀ�����������Ȥ
/* �����ӡ�ļ���Ϣ�� ---> */
String filename = "E:\\IOtest\\Top20\\test_result\\firstpage.txt";
File file =new File(filename);
if(!file.exists())
{
	file.createNewFile();
}
FileOutputStream fs = new FileOutputStream(file,true);
OutputStreamWriter out =new OutputStreamWriter(fs,"UTF-8");
PrintStream p = new PrintStream(fs);
/* <--- �����ӡ�ļ���Ϣ�� */

/*�����߼�������*/
String Errmessage_str = "Error:δ�����ֶΣ�";
public void jadgepara( Object[] para_arr )
{
	str1 = "Error:δ�����ֶ�---";
	str2 = "Error:�ֶη��ش���---";
	
	for( m=0; m<1000; m++ )
	{
		if(para_arr[m][0] != null)
		{
			obj = para_arr[m][0];
			para = para_arr[m][1];
			item = para_arr[m][2];
			
			if(!obj.containsKey(para))
			{
				p.println( str1 + para + "--" + item );									//Error:δ�����ֶ�---xxx
				ass = true;
			}
			else
			{
				para_str = obj.get(para)+"";
				if((para_str == null) || (para_str.equals("-1")))
				{
					p.println( str2 + para + "--" + item );								//Error:�ֶη��ش���---xxx
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

/*�����߼�������*/

String jsonString = prev.getResponseDataAsString();					//��ȡjson��
JSONObject List = JSONValue.parse(jsonString);						//����ȡjson������List


/*������Ϣ*/
if(!List.containsKey("code"))										//������
{
	p.println( Errmessage_str + "code" );
	ass = true;
}
else
{
	code_str = List.get("code");
	if(!code_str.equals("0"))
	{
		p.println( "Error���ӿڷ���ʧ�ܣ������룺" + code_str );
		ass = true;
	}
}
if(!List.containsKey("qq"))											//qq
{
	p.println( Errmessage_str + "qq" );
	ass = true;
}
if(!List.containsKey("prefer"))										//ƫ��
{
	p.println( Errmessage_str + "prefer" );
	ass = true;
}
else
{
	prefer_l = List.get("prefer");
	if(prefer_l == -1)
	{
		p.println( "Error��prefer�ֶη��ش���" );
		ass = true;
	}
}
if(!List.containsKey("sex"))										//�Ա�
{
	p.println( Errmessage_str + "sex" );
	ass = true;
}
else
{
	sex_l = List.get("sex");
	if(sex_l == -1)
	{
		p.println( "Error��sex�ֶη��ش���" );
		ass = true;
	}
}
if(!List.containsKey("isVip"))										//��Ա״̬
{
	p.println( Errmessage_str + "isVip" );
	ass = true;
}
else
{
	isVip_str = List.get("isVip") + "";
	if(isVip_str == null)
	{
		p.println( "Error��isVip�ֶη��ش���" );
		ass = true;
	}
}
if(!List.containsKey("isLogin"))										//��¼״̬
{
	p.println( Errmessage_str + "isLogin" );
	ass = true;
}
else
{
	isLogin_str = List.get("isLogin") + "";
	if(isLogin_str == null)
	{
		p.println( "Error��isLogin�ֶη��ش���" );
		ass = true;
	}
}

list_arr = List.get("list");

for( i=0; i<list_arr.size(); i++ )
{
	list_tmp = list_arr.get(i);
	style_l =  list_tmp.get("style");
	
	/*�����*/
	if( style_l == 1 )
	{
		content_arr = list_tmp.get("content");
		for( j=0; j<content_arr.size(); j++ )
		{
			content_arr_obj = content_arr.get(j);
			
			Object[][] para_arr = 
			{
				{content_arr_obj,	"adid",			"�����  "	},
				{content_arr_obj,	"fontcolor",	"�����  "	},
				{content_arr_obj,	"icon",			"�����  "	},
				{content_arr_obj,	"name",			"�����  "	},
				{content_arr_obj,	"positionId",	"�����  "	},
				{content_arr_obj,	"qurl",			"�����  "	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);


			stat_params_obj =  content_arr_obj.get("stat_params");
			
			Object[][] para_arr = 
			{
				{stat_params_obj,	"alg",			"�����  "	},
				{stat_params_obj,	"data_type",	"�����  "	},
				{stat_params_obj,	"origin",		"�����  "	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);
			
			

		}
	}
	/* ���ձض� */
	else if( style_l == 8 )
	{
		if( list_tmp.containsKey("content") )
		{
			content_obj = list_tmp.get("content");
			
			Object[][] para_arr = 
			{
				{content_obj,	"qurl",		"���ձض�  "	},
				{content_obj,	"title",	"���ձض�  "	},
				{null,				null,		null			},
			};
			jadgepara(para_arr);


			bookList_obj = content_obj.get("bookList");
			bookcount = bookList_obj.size();
			if(bookcount <= 5)
			{
				p.println( "Error�������鼮����С��5����ˢ�²���仯(���ձض�)" );
				ass = true;
			}
			for( j=0; j<bookList_obj.size(); j++ )
			{
				JSONObject bookList_obj_tmp = bookList_obj.get(j);
				
				Object[][] para_arr = 
				{
					{bookList_obj_tmp,	"title",	"���ձض�  "	},
					{bookList_obj_tmp,	"bid",		"���ձض�  "	},
					{bookList_obj_tmp,	"intro",	"���ձض�  "	},
					{bookList_obj_tmp,	"author",	"���ձض�  "	},
					{null,				null,		null			},
				};
				jadgepara(para_arr);
			}
		}
		else
		{
			p.println( "Error��û�з����鼮����(���ձض�)" );
			ass = true;
		}
	}
	/* ���Ի���Ӫ��Ŀһ */
	else if( style_l == 5 )
	{
		if( list_tmp.containsKey("content") )
		{
			/* ר���Ƽ� */
			
			content_arr = list_tmp.get("content");
			content_arr_obj = content_arr.get(0);
			
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"ר���Ƽ�"	},
				{content_arr_obj,	"uistyle",		"ר���Ƽ�"	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);

			
			content_obj = content_arr_obj.get("content");
			if(!content_obj.containsKey("bids"))											//��Ҫ���û���
			{
				Object[][] para_arr = 
				{
					{content_obj,	"qurl",		"ר���Ƽ�"	},
					{content_obj,	"time",		"ר���Ƽ�"	},
					{content_obj,	"title",	"ר���Ƽ�"	},
					{content_obj,	"desc",		"ר���Ƽ�"	},
					{null,			null,		null		},
				};
				jadgepara(para_arr);
			}
			else																			//����Ҫ���û���
			{
				Object[][] para_arr = 
				{
					{content_obj,	"qurl",		"ר���Ƽ�"	},
					{content_obj,	"time",		"ר���Ƽ�"	},
					{null,			null,		null		},
				};
				jadgepara(para_arr);
				
				bids_arr = content_obj.get("bids");											//չʾ���(bid)
				bidsize_l = bids_arr.size();
				if(bidsize_l<=3)
				{
					p.println( "Error������bid����С��3��ˢ�²���仯(���Ի��Ƽ�)" );
					ass = true;
				}

				info_arr = content_obj.get("info");
				info_arr_obj = info_arr.get(0);
				
				Object[][] para_arr = 
				{
					{info_arr_obj,	"title",	"ר���Ƽ�"	},
					{info_arr_obj,	"desc",		"ר���Ƽ�"	},
					{null,			null,		null		},
				};
				jadgepara(para_arr);
			}
			/* ��Ʒר�� */
			content_arr = list_tmp.get("content");
			content_arr_obj = content_arr.get(1);
			
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"��Ʒר��"	},
				{content_arr_obj,	"uistyle",		"��Ʒר��"	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);

			
			content_obj = content_arr_obj.get("content");
			bids_arr = content_obj.get("bids");
			bidsize_l = bids_arr.size();
			if(bidsize_l == 0 )
			{
				p.println( "Error��û�з����鼮,��¶����޷�չʾ" );
				ass = true;
			}
			else if(bidsize_l <= 3 )
			{
				p.println( "Error�������鼮����С��3��ˢ����¶��ⲻ�仯(��Ʒר��)" );
				ass = true;
			}
			
			Object[][] para_arr = 
			{
				{content_obj,	"qurl",	"��Ʒר��"	},
				{null,			null,	null		},
			};
			jadgepara(para_arr);

			info_arr = content_obj.get("info");
			infosize_l = info_arr.size();
			if( infosize_l <= 1 )
			{
				p.println( "Error��������ʽС��1��ˢ�²��仯(��Ʒר��)" );
				ass = true;
			}
			for( j=0; j<info_arr.size(); j++ )
			{
				info_arr_obj = info_arr.get(j);
				Object[][] para_arr = 
				{
					{info_arr_obj,	"title",	"��Ʒר��"	},
					{info_arr_obj,	"desc",		"��Ʒר��"	},
					{null,			null,		null		},
				};
				jadgepara(para_arr);
			}
			/* ��������/����/����� */
			content_arr = list_tmp.get("content");
			content_arr_obj = content_arr.get(2);
			
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"��������/����/�����"	},
				{content_arr_obj,	"uistyle",		"��������/����/�����"	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);

			content_arr_obj_arr = content_arr_obj.get("content");
			for( j=0; j<content_arr_obj_arr.size(); j++ )
			{
				content_arr_obj_arr_obj = content_arr_obj_arr.get(j);

				Object[][] para_arr = 
				{
					{content_arr_obj_arr_obj,	"qurl",	"��������/����/�����"	},
					{content_arr_obj_arr_obj,	"title","��������/����/�����"	},
					{content_arr_obj_arr_obj,	"desc",	"��������/����/�����"	},
					{null,						null,	null		},
				};
				jadgepara(para_arr);
			}
			
			/* Ӱ��ԭ�� */
			content_arr = list_tmp.get("content");
			content_arr_obj = content_arr.get(3);

			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"Ӱ��ԭ��"	},
				{content_arr_obj,	"uistyle",		"Ӱ��ԭ��"	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);


			content_arr_obj_arr = content_arr_obj.get("content");
			for( j=0; j<content_arr_obj_arr.size(); j++ )
			{
				content_arr_obj_arr_obj = content_arr_obj_arr.get(j);
				
				Object[][] para_arr = 
				{
					{content_arr_obj_arr_obj,	"image",	"Ӱ��ԭ��"	},
					{content_arr_obj_arr_obj,	"qurl",		"Ӱ��ԭ��"	},
					{content_arr_obj_arr_obj,	"title",	"Ӱ��ԭ��"	},
					{content_arr_obj_arr_obj,	"desc",		"Ӱ��ԭ��"	},
					{null,				null,		null		},
				};
				jadgepara(para_arr);
			}
		}
		else
		{
			p.println( "Error�����Ի���Ŀһû�з�������" );
			ass = true;
		}
	}
	/* �����Ƽ� */
	else if( style_l == 9 )
	{
		content_arr = list_tmp.get("content");

		for( j=0; j<content_arr.size(); j++ )
		{
			content_arr_obj = content_arr.get(j);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"image",		"�����Ƽ�"	},
				{content_arr_obj,	"preference",	"�����Ƽ�"	},
				{content_arr_obj,	"qurl",			"�����Ƽ�"	},
				{content_arr_obj,	"title",		"�����Ƽ�"	},
				{content_arr_obj,	"pushName",		"�����Ƽ�"	},
				{content_arr_obj,	"desc",			"�����Ƽ�"	},
				{null,				null,			null		},
			};
			jadgepara(para_arr);
		
			bookList_arr = content_arr_obj.get("bookList");
			bookList_arr_obj = bookList_arr.get(0);
			Object[][] para_arr = 
			{
				{bookList_arr_obj,	"catel3name",		"�����Ƽ�"	},
				{bookList_arr_obj,	"totalWords",		"�����Ƽ�"	},
				{bookList_arr_obj,	"author",			"�����Ƽ�"	},
				{bookList_arr_obj,	"cpushName",		"�����Ƽ�"	},
				{bookList_arr_obj,	"exquisite",		"�����Ƽ�"	},
				{bookList_arr_obj,	"finished",			"�����Ƽ�"	},
				{bookList_arr_obj,	"updateTime",		"�����Ƽ�"	},
				{bookList_arr_obj,	"title",			"�����Ƽ�"	},
				{bookList_arr_obj,	"categoryName",		"�����Ƽ�"	},
				{bookList_arr_obj,	"lastChapter",		"�����Ƽ�"	},
				{bookList_arr_obj,	"unitprice",		"�����Ƽ�"	},
				{bookList_arr_obj,	"catel2name",		"�����Ƽ�"	},
				{bookList_arr_obj,	"form",				"�����Ƽ�"	},
				{bookList_arr_obj,	"price",			"�����Ƽ�"	},
				{bookList_arr_obj,	"intro",			"�����Ƽ�"	},
				{bookList_arr_obj,	"bid",				"�����Ƽ�"	},
				{null,				null,				null		},
			};
			jadgepara(para_arr);
		}
	}
	/* ������ɱ */
	else if( style_l == 13 )
	{
		content_obj = list_tmp.get("content");
		
		Object[][] para_arr = 
		{
			{content_obj,	"currentTime",	"������ɱ"	},
			{content_obj,	"endTime",		"������ɱ"	},
			{content_obj,	"qurl",			"������ɱ"	},
			{content_obj,	"title",		"������ɱ"	},
			{content_obj,	"pushName",		"������ɱ"	},
			{content_obj,	"desc",			"������ɱ"	},
			{null,			null,			null		},
		};
		jadgepara(para_arr);

		bookList_arr = content_obj.get("bookList");
		for( j=0; j<bookList_arr.size(); j++ )
		{
			bookList_arr_obj = bookList_arr.get(j);
			Object[][] para_arr = 
			{
				{bookList_arr_obj,	"originalPrice",	"������ɱ"	},
				{bookList_arr_obj,	"discountPrice",	"������ɱ"	},
				{bookList_arr_obj,	"bid",				"������ɱ"	},
				{bookList_arr_obj,	"title",			"������ɱ"	},
				{null,				null,				null		},
			};
			jadgepara(para_arr);
		}
	}
	/* ���Ի���Ŀ�� */
	else if( style_l == 6 )
	{
		if( list_tmp.containsKey("content") )
		{
			content_arr = list_tmp.get("content");
			
			/* ���� */
			content_arr_obj = content_arr.get(0);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"���Ի���Ŀ��---����"	},
				{content_arr_obj,	"uistyle",		"���Ի���Ŀ��---����"	},
				{null,				null,			null					},
			};
			jadgepara(para_arr);
			
			content_arr_obj_arr = content_arr_obj.get("content");
			for( j=0; j<content_arr_obj_arr.size(); j++ )
			{
				content_arr_obj = content_arr_obj_arr.get(j);
				Object[][] para_arr = 
				{
					{content_arr_obj,	"image",	"���Ի���Ŀ��---����"	},
					{content_arr_obj,	"qurl",		"���Ի���Ŀ��---����"	},
					{content_arr_obj,	"title",	"���Ի���Ŀ��---����"	},
					{content_arr_obj,	"desc",		"���Ի���Ŀ��---����"	},
					{null,				null,		null					},
				};
				jadgepara(para_arr);
			}

			/* ����ing */
			content_arr_obj = content_arr.get(1);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"���Ի���Ŀ��---����ing  "	},
				{content_arr_obj,	"uistyle",		"���Ի���Ŀ��---����ing  "	},
				{null,				null,			null						},
			};
			jadgepara(para_arr);
			content_arr_obj_obj = content_arr_obj.get("content");
			Object[][] para_arr = 
			{
				{content_arr_obj_obj,	"bids",	"���Ի���Ŀ��---����ing  "	},
				{content_arr_obj_obj,	"qurl",	"���Ի���Ŀ��---����ing  "	},
				{null,				null,	null					},
			};
			jadgepara(para_arr);
			info_arr = content_arr_obj_obj.get("info");
			for( j=0; j<info_arr.size(); j++ )
			{
				info_arr_obj = info_arr.get(j);
				Object[][] para_arr = 
				{
					{info_arr_obj,	"title",	"���Ի���Ŀ��---����ing---info[]:"	},
					{info_arr_obj,	"desc",		"���Ի���Ŀ��---����ing---info[]:"	},
					{null,			null,		null					},
				};
				jadgepara(para_arr);
			}
			
			/* �����ؼ� */
			content_arr_obj = content_arr.get(2);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"���Ի���Ŀ��---�����ؼ�  "	},
				{content_arr_obj,	"uistyle",		"���Ի���Ŀ��---�����ؼ�  "	},
				{null,				null,			null						},
			};
			jadgepara(para_arr);
			
			content_arr_obj_obj = content_arr_obj.get("content");
			Object[][] para_arr = 
			{
				{content_arr_obj_obj,	"bids",	"���Ի���Ŀ��---�����ؼ�  "	},
				{content_arr_obj_obj,	"qurl",	"���Ի���Ŀ��---�����ؼ�  "	},
				{null,				null,	null					},
			};
			jadgepara(para_arr);
			
			info_arr = content_arr_obj_obj.get("info");
			for( j=0; j<info_arr.size(); j++ )
			{
				info_arr_obj = info_arr.get(j);
				Object[][] para_arr = 
				{
					{info_arr_obj,	"title",	"���Ի���Ŀ��---�����ؼ�---info[]:"	},
					{info_arr_obj,	"desc",		"���Ի���Ŀ��---�����ؼ�---info[]:"	},
					{null,			null,		null					},
				};
				jadgepara(para_arr);
			}
			
			/* ����ר�� */
			content_arr_obj = content_arr.get(3);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"���Ի���Ŀ��---����ר��  "	},
				{content_arr_obj,	"uistyle",		"���Ի���Ŀ��---����ר��  "	},
				{null,				null,			null						},
			};
			jadgepara(para_arr);
			
			content_arr_obj_arr = content_arr_obj.get("content");
			content_arr_obj_arr_obj = content_arr_obj_arr.get(0);
			Object[][] para_arr = 
			{
				{content_arr_obj_arr_obj,	"image",	"���Ի���Ŀ��---����ר��  "	},
				{content_arr_obj_arr_obj,	"qurl",		"���Ի���Ŀ��---����ר��  "	},
				{content_arr_obj_arr_obj,	"title",	"���Ի���Ŀ��---����ר��  "	},
				{content_arr_obj_arr_obj,	"desc",		"���Ի���Ŀ��---����ר��  "	},
				{null,						null,		null					},
			};
			jadgepara(para_arr);
			
			/* ����ר�� */
			content_arr_obj = content_arr.get(4);
			Object[][] para_arr = 
			{
				{content_arr_obj,	"positionId",	"���Ի���Ŀ��---����ר��  "	},
				{content_arr_obj,	"uistyle",		"���Ի���Ŀ��---����ר��  "	},
				{null,				null,			null						},
			};
			jadgepara(para_arr);
			
			content_arr_obj_arr = content_arr_obj.get("content");
			content_arr_obj_arr_obj = content_arr_obj_arr.get(0);
			Object[][] para_arr = 
			{
				{content_arr_obj_arr_obj,	"image",	"���Ի���Ŀ��---����ר��  "	},
				{content_arr_obj_arr_obj,	"qurl",		"���Ի���Ŀ��---����ר��  "	},
				{content_arr_obj_arr_obj,	"title",	"���Ի���Ŀ��---����ר��  "	},
				{content_arr_obj_arr_obj,	"desc",		"���Ի���Ŀ��---����ר��  "	},
				{null,						null,		null					},
			};
			jadgepara(para_arr);
		}
		else
		{
			p.println( "Error�����Ի���Ŀ��û�з�������" );
			ass = true;
		}
	}
	/* �������Ȥ */
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
					{content_arr_obj,	"bookNum",	"�������Ȥ  "	},
					{content_arr_obj,	"bids",		"�������Ȥ  "	},
					{content_arr_obj,	"qurl",		"�������Ȥ  "	},
					{content_arr_obj,	"catename",	"�������Ȥ  "	},
					{null,				null,		null			},
				};
				jadgepara(para_arr);
				
				bids_arr = content_arr_obj.get("bids");
				bids_size_l = bids_arr.size();
				if(bids_size_l < 3)
				{
					p.println( "Error���������Ȥ����bid��ĿС��3" );
					ass = true;
				}
			}
		}
		else
		{
			p.println( "Error���������Ȥû�з�������" );
			ass = true;
		}
	}

}


p.close();
}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
