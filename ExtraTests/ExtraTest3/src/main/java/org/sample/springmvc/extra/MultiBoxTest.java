package org.sample.springmvc.extra;

import java.util.ArrayList;
import java.util.List;

public class MultiBoxTest {
    private String[] data;
    private Boolean checked;
    private Boolean[] checkedArray;
    private List<String> checkedList = new ArrayList<String>();

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

    public List<String> getCheckedList() {
        return checkedList;
    }

    public void setCheckedList(List<String> checkedList) {
        this.checkedList = checkedList;
    }
}
