package org.sample.springmvc.extra;

import java.util.List;

public class UserData2 {

    private String[] idArray;
    public String[] getIdArray() {
        return idArray;
    }

    public List<String> getNameList() {
        return nameList;
    }

    private List<String> nameList;

    public void setIdArray(String[] ids) {
        this.idArray = ids;
    }

    public void setNameList(List<String> names) {
        this.nameList = names;
    }

}
