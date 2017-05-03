package com.mmjang.ankihelperrefactor.app;

/**
 * Created by liao on 2017/4/13.
 */

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 单例，getInstance()得到实例
 */
public class Settings {

    private static Settings settings = null;

    private final static String PREFER_NAME = "settings";    //应用设置名称
    private final static String MODEL_ID = "model_id";       //应用设置项 模版id
    private final static String DECK_ID = "deck_id";         //应用设置项 牌组id
    private final static String DEFAULT_MODEL_ID = "default_model_id"; //默认模版id，如果此选项存在，则已写入配套模版
    private final static String FIELDS_MAP = "fields_map";   //字段映射
    private final static String MONITE_CLIPBOARD_Q = "show_clipboard_notification_q";   //是否监听剪切板
    private final static String AUTO_CANCEL_POPUP_Q = "auto_cancel_popup";              //点加号后是否退出
    private final static String DEFAULT_PLAN = "default_plan";
    private final static String LAST_SELECTED_PLAN = "last_selected_plan";

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private Settings(Context context){
        sp = context.getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    /**
     * 获得单例
     * @return
     */
    public static Settings  getInstance(Context context){
        if(settings == null){
            settings = new Settings(context);
        }
        return settings;
    }

    /*************/

    Long getModelId(){
        return sp.getLong(MODEL_ID, 0);
    }

    void setModelId(Long modelId){
        editor.putLong(MODEL_ID, modelId);
        editor.commit();
    }
    /**************/

    Long getDeckId(){
        return sp.getLong(DECK_ID, 0);
    }

    void setDeckId(Long deckId){
        editor.putLong(DECK_ID, deckId);
        editor.commit();
    }
    /**************/

    Long getDefaultModelId(){
        return sp.getLong(DEFAULT_MODEL_ID, 0);
    }

    void setDefaultModelId(Long defaultModelId){
        editor.putLong(DEFAULT_MODEL_ID, defaultModelId);
        editor.commit();
    }
    /**************/

    String getFieldsMap(){
        return sp.getString(FIELDS_MAP, "");
    }

    void setFieldsMap(String filedsMap){
        editor.putString(FIELDS_MAP, filedsMap);
        editor.commit();
    }
    /**************/

    boolean getMoniteClipboardQ(){
        return sp.getBoolean(MONITE_CLIPBOARD_Q, true);
    }

    void setMoniteClipboardQ(boolean moniteClipboardQ){
        editor.putBoolean(MONITE_CLIPBOARD_Q, moniteClipboardQ);
        editor.commit();
    }
    /**************/

    boolean getAutoCancelPopupQ(){
        return sp.getBoolean(AUTO_CANCEL_POPUP_Q, true);
    }

    void setAutoCancelPopupQ(boolean autoCancelPopupQ){
        editor.putBoolean(AUTO_CANCEL_POPUP_Q, autoCancelPopupQ);
        editor.commit();
    }
    /**************/
    public String getDefaultPlan() {
        return sp.getString(DEFAULT_PLAN, "");
    }

    public void setDefaultPlan(String defaultPlan) {
        editor.putString(DEFAULT_PLAN, defaultPlan);
        editor.commit();
    }

    public String getLastSelectedPlan(){
        return sp.getString(LAST_SELECTED_PLAN, "");
    }

    public void setLastSelectedPlan(String lastSelectedPlan){
        editor.putString(LAST_SELECTED_PLAN, lastSelectedPlan);
        editor.commit();
    }

    /**************/
    boolean hasKey(String key){
        return sp.contains(key);
    }


}