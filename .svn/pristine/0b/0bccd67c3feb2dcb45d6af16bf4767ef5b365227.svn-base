package com.xym.bossed.servlet.cangku;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.cangku.CangKu;
import com.xym.bossed.service.CangKuService;

public class CangKuList extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		CangKuService cks=new CangKuService();
		List<CangKu> ckList=cks.getAllCangKu();
        List<ComboBoxData> cbdList=new ArrayList<ComboBoxData>();
		/**
		 * change the cangku data format to combox data format, like below:
		 * <input class="easyui-combobox" data-options="
		valueField: 'label',
		textField: 'value',
		data: [{
			label: 'java',
			value: 'Java'
		},{
			label: 'perl',
			value: 'Perl'
		},{
			label: 'ruby',
			value: 'Ruby'
		}]" />
		 */
        for(int i=0;i<ckList.size();i++)
        {
        	CangKu ck=ckList.get(i);
        	ComboBoxData cbd=new ComboBoxData();
        	cbd.setLabel(ck.getMingCheng());
        	cbd.setValue(ck.getDaiMa());
        	
        	cbdList.add(cbd);
        }
        
        response.getWriter().println(JSONArray.fromObject(cbdList).toString());
        
	}
	public class ComboBoxData{
		private String label,value;

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
