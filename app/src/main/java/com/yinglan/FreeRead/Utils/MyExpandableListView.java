package com.yinglan.FreeRead.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yinglan.FreeRead.R;

/**
 * Created by ${AUTHOR} on 2019/3/28 0028
 * Function: ${Function}
 */
public class MyExpandableListView extends BaseExpandableListAdapter {


    private Context context;
    //一级列表数据源
    private String[] groups;
    //二级列表数据源
    private String[][] childs;


    public MyExpandableListView(Context context,String[] groups,String[][] childs){
        this.context = context;
        this.groups = groups;
        this.childs = childs;
    }


    /*一级列表个数*/
    @Override
    public int getGroupCount() {
        return groups.length;
    }

    /*每个二级列表的个数*/
    @Override
    public int getChildrenCount(int groupPosition) {
        return childs[groupPosition].length;
    }

    /*一级列表中单个item*/
    @Override
    public Object getGroup(int groupPosition) {
        return groups[groupPosition];
    }

    /*二级列表中单个item*/
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childs[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /*每个item的id是否固定，一般为true*/
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /*#TODO 填充一级列表
     * isExpanded 是否已经展开
     * */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.expandable_one,null);
        }
        TextView tv_group = (TextView) convertView.findViewById(R.id.tv_group);
        tv_group.setText(groups[groupPosition]);

        return convertView;
    }

    /*#TODO 填充二级列表*/
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.expandable_two,null);

        }
        TextView expandable_two_title = (TextView) convertView.findViewById(R.id.expandable_two_title);
        TextView expandable_two_sate = (TextView) convertView.findViewById(R.id.expandable_two_sate);
        TextView expandable_two_time = (TextView) convertView.findViewById(R.id.expandable_two_time);
        TextView expandable_two_info = (TextView) convertView.findViewById(R.id.expandable_two_info);

        expandable_two_title.setText(childs[groupPosition][childPosition]);


        return convertView;
    }

    /*二级列表中每个能否被选中，如果有点击事件一定要设为true*/
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
