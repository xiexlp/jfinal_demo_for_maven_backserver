package com.js.common.util;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ControllerAdaper extends Controller {

	public  void showResult(int r){
		if(r>0){
			System.out.println("操作成功:"+r);
		}else {
			System.out.println("操作失败:"+r);
		}
		renderJson(r);
	}

	protected int getIntPara(String name, int d) {
		int r = 0;
		Integer v = getParaToInt(name);
		if (v != null) {
			r = v;
		} else {
			r = d;
		}
		return r;
	}
	
	protected int getIntPara(String name) {
		int r = 0;
		Integer v = getParaToInt(name);
		if (v != null) {
			r = v;
		}
		return r;
	}

	protected double getDoublePara(String name, double d) {
		double r = 0;
		String value =getRequest().getParameter(name);
		if(value==null||value.equalsIgnoreCase("")) return 0;
		Double v = Double.parseDouble(value);
		if (v != null) {
			r = v;
		} else {
			r = d;
		}
		return r;
	}


	protected double getDoublePara(String name) {
		double r = 0;
		Double v = getDoublePara(name,0);
		if (v != null) {
			r = v;
		}
		return r;
	}
	
	
	protected long getLongPara(String name, long d) {
		long r = 0;
		Long v = getParaToLong(name);
		if (v != null) {
			r = v;
		} else {
			r = d;
		}
		return r;
	}
	
	
	protected long getLongPara(String name) {
		long r = 0;
		Long v = getParaToLong(name);
		if (v != null) {
			r = v;
		}
		return r;
	}
	
	protected String getStrPara(String name,String d) {
		String r = "";
		String v = getPara(name);
		if (v != null) {
			r = v;
		} else {
			r = d;
		}
		return r;
	}

	/**
	 * 带默认值
	 * @param name
	 * @param defaultTime
	 * @return
	 */
	protected Timestamp getTimeStampPara(String name,Timestamp defaultTime){
		String timestamp = "";
		Timestamp timestamp1 =null;
		try {
			 timestamp = getStrPara(name,"");
			 if(timestamp.equalsIgnoreCase("")){
			 	return defaultTime;
			 }
			 timestamp1 = TimeUtil.string2Time(timestamp);
		}catch (Exception e){
			e.printStackTrace();
		}
		return timestamp1;
	}

	/**
	 * 默认值为当前时间
	 * @param name
	 * @return
	 */
	protected Timestamp getTimestampPara(String name){
		String timestamp = "";
		Timestamp timestamp1 =null;
		try {
			timestamp = getStrPara(name,"");
			System.out.println("time stamp:"+timestamp);
			if(timestamp==null||timestamp.equalsIgnoreCase("")){
				timestamp1 = new Timestamp(System.currentTimeMillis());
				return timestamp1;
			}
			timestamp1 = TimeUtil.string2Time(timestamp);
		}catch (Exception e){
			e.printStackTrace();
		}
		return timestamp1;
	}


	protected Date getDatePara(String name){
		String timestamp = "";
		Date timestamp1 =null;
		try {
			timestamp = getStrPara(name,"");
			if(timestamp.equalsIgnoreCase("")){
				timestamp1 = new Date(System.currentTimeMillis());
				return timestamp1;
			}
			timestamp1 = TimeUtil.string2Date(timestamp);
		}catch (Exception e){
			e.printStackTrace();
		}
		return timestamp1;
	}
	
	protected String getStrPara(String name) {
		String r = "";
		String v = getPara(name);
		if (v != null) {
			r = v;
		} else {
			r = "";
		}
		return r;
	}

//	protected <T> T mapping(Class<T> z) {
//		T o = null;
//		try {
//			o = z.newInstance();
//			BeanUtils.populate(o, this.getParaMap());
//			return o;
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

	protected <T> void setPageInfo(PageList<T> pageList,String actionUrl){
		PageInfo pageInfo = new PageInfo(pageList.getPageNo(),pageList.getPageTotal());
		pageInfo.setActionUrl(actionUrl);
		pageList.setActionUrl(actionUrl);

		setAttr("pageinfo", pageInfo);
		setAttr("pageNo", pageInfo.getPageNo());
		setAttr("pageTotal", pageInfo.getPageTotal());
		setAttr("actionUrl", actionUrl);
		setAttr("total", pageList.getTotal());
		setAttr("pageSize",pageList.getPageSize());

		Pagination pagination =new Pagination();
		pagination.paginationTool(pageInfo.getPageNo(), pageInfo.getPageTotal());
		List<Integer> pageNoList =new ArrayList();
		//1不在里面的话把第一页增加进去
		if(pagination.getStartPage()>1){
			pageNoList.add(1);
		}
		for(int i=pagination.getStartPage();i<=pagination.getEndPage();i++){
			pageNoList.add(i);
		}
		pageList.setPageNoList(pageNoList);

		setAttr("pageNoList",pageNoList);
	}

    protected <T> void setPageInfo(PageList<T> pageList,String actionUrl,Pager pager){
        PageInfo pageInfo = new PageInfo(pageList.getPageNo(),pageList.getPageTotal());
        pageInfo.setActionUrl(actionUrl);
        pageInfo.setTotal(pageList.getTotal());

        pageList.setActionUrl(actionUrl);

        setAttr("pageinfo", pageInfo);
        setAttr("pageNo", pageInfo.getPageNo());
        setAttr("pageTotal", pageInfo.getPageTotal());
        setAttr("actionUrl", actionUrl);
        setAttr("total", pageList.getTotal());
        setAttr("pageSize",pageList.getPageSize());

        Pagination pagination =new Pagination();
        pagination.paginationTool(pageInfo.getPageNo(), pageInfo.getPageTotal());
        List<Integer> pageNoList =new ArrayList();
        //1不在里面的话把第一页增加进去
        if(pagination.getStartPage()>1){
            pageNoList.add(1);
        }
        for(int i=pagination.getStartPage();i<=pagination.getEndPage();i++){
            pageNoList.add(i);
        }
        pageList.setPageNoList(pageNoList);

        pager.setPageInfo(pageInfo);


        setAttr("pageNoList",pageNoList);
    }

	protected <T> void setPageInfo(PageList<T> pageList){
		PageInfo pageInfo = new PageInfo(pageList.getPageNo(),pageList.getPageTotal());
		setAttr("pageinfo", pageInfo);
		setAttr("pageNo", pageInfo.getPageNo());
		setAttr("pageTotal", pageInfo.getPageTotal());
	}

	protected void setPageInfo(int pageNo,int pageTotal){
		PageInfo pageInfo = new PageInfo(pageNo,pageTotal);
		setAttr("pageinfo", pageInfo);
		setAttr("pageNo", pageInfo.getPageNo());
		setAttr("pageTotal", pageInfo.getPageTotal());
	}
	
	
	/**
     * 对文章内容进行节选
     * @param content
     * @return
     */
    protected String getSubContentFormat(String content){
        //文章内容
        String subcontent = StringProcess.cutBefore200(content, 200);
        subcontent =subcontent.replaceAll("<p >"," ").replaceAll("<p>"," ").replaceAll("</p>"," ").replaceAll("<strong>"," ").replaceAll("</strong>"," ").replaceAll("<br/>"," ");
        //图片
        String subcontent_img = subcontent.replaceAll("<img.*/>", "<upload>/pic...</upload>");
        System.out.println("内容:"+subcontent_img);
        return subcontent_img;

    }
    
    
    protected int getUserId(){
		int userID = getIntSessionValue("userId",1);
		return userID;
	}

	protected String getUsername(){
		String username = getSessionValue("username","");
		return username;
	}
	
	
	protected String getSessionValue(String key, String defaultValue) {
		String value = getSessionAttr(key);
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}
	
	protected Integer getIntSessionValue(String key, Integer defaultValue) {
		Integer value = (Integer) getSessionAttr(key);
		if(value==null){
			value =defaultValue;
		}
		return value;
		// return value==null?Integer.parseInt(value):defaultValue;
	}

	public  int getIntSession(HttpSession session,String key) {
		int x=-1;
		Object o=session.getAttribute(key);
		if(o!=null){
			x= (Integer)o;
		}
		return x;
	}
	
	public static HttpSession getSession(Invocation inv) {
		Controller controller = inv.getController();
		HttpSession session = controller.getSession();
		return session;
	}
}
