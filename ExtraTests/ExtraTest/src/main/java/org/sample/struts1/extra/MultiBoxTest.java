package org.sample.struts1.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class MultiBoxTest extends ActionForm {
    private static final long serialVersionUID = 1L;
    private String[] data;
    private Integer[] intData;
    private Boolean checked;
    private Boolean[] checkedArray;
    private List<String> dataList;
    private List<IndexedData> idxData;
    
    public IndexedData getItem(int idx) {
        while(idx >= this.idxData.size()) {
            this.idxData.add(new IndexedData());
        }
        return this.idxData.get(idx);
    }
    
    public List<IndexedData> getIndexedData() {
        return this.idxData;
    }

    public void setIndexedData(List<IndexedData> idxData) {
        this.idxData = idxData;
    }
    
    public List<String> getDataList() {
        return dataList;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
    
    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean[] getCheckedArray() {
        return checkedArray;
    }

    public void setCheckedArray(Boolean[] checkedArray) {
        this.checkedArray = checkedArray;
    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        System.out.println("Reset data");
        data = null;
        checked = false;
        checkedArray = null;
        intData = null;
        dataList = Arrays.asList("", "");
        this.idxData = Arrays.asList(new IndexedData(), new IndexedData(), new IndexedData());
    }

    public Integer[] getIntData() {
        return intData;
    }

    public void setIntData(Integer[] intData) {
        this.intData = intData;
    }

    public String getListData(int idx) {
        return dataList.get(idx);
    }

    public void setListData(int idx, String listData) {
        this.dataList.set(idx, listData);
    }

}
