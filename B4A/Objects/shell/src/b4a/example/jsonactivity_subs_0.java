package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class jsonactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (jsonactivity) ","jsonactivity",2,jsonactivity.mostCurrent.activityBA,jsonactivity.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) return b4a.example.jsonactivity.remoteMe.runUserSub(false, "jsonactivity","activity_create", _firsttime);
RemoteObject _js = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 27;BA.debugLine="Activity.Title = \"JSListAdapter (ListAdapter)\"";
Debug.ShouldStop(67108864);
jsonactivity.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("JSListAdapter (ListAdapter)"));
 BA.debugLineNum = 28;BA.debugLine="Activity.AddMenuItem(\"Add\", \"mnuAdd\")";
Debug.ShouldStop(134217728);
jsonactivity.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToCharSequence("Add")),(Object)(RemoteObject.createImmutable("mnuAdd")));
 BA.debugLineNum = 32;BA.debugLine="Dim js As JSONParser";
Debug.ShouldStop(-2147483648);
_js = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("js", _js);
 BA.debugLineNum = 33;BA.debugLine="js.Initialize(File.ReadString(File.DirAssets, \"MO";
Debug.ShouldStop(1);
_js.runVoidMethod ("Initialize",(Object)(jsonactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(jsonactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("MOCK_DATA.json")))));
 BA.debugLineNum = 36;BA.debugLine="Dim data As List =  js.NextArray";
Debug.ShouldStop(8);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_data = _js.runMethod(false,"NextArray");Debug.locals.put("data", _data);Debug.locals.put("data", _data);
 BA.debugLineNum = 39;BA.debugLine="Adapter.Initialize(\"Adapter\", data)";
Debug.ShouldStop(64);
jsonactivity.mostCurrent._adapter.runVoidMethod ("Initialize",jsonactivity.processBA,(Object)(BA.ObjectToString("Adapter")),(Object)(_data));
 BA.debugLineNum = 42;BA.debugLine="LV.Initialize(\"LV\")";
Debug.ShouldStop(512);
jsonactivity.mostCurrent._lv.runVoidMethod ("Initialize",jsonactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("LV")));
 BA.debugLineNum = 43;BA.debugLine="Activity.AddView(LV, 0dip, 0dip, 100%x, 100%y)";
Debug.ShouldStop(1024);
jsonactivity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((jsonactivity.mostCurrent._lv.getObject())),(Object)(jsonactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(jsonactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(jsonactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),jsonactivity.mostCurrent.activityBA)),(Object)(jsonactivity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),jsonactivity.mostCurrent.activityBA)));
 BA.debugLineNum = 44;BA.debugLine="LV.Adapter = Adapter";
Debug.ShouldStop(2048);
jsonactivity.mostCurrent._lv.runMethod(false,"setAdapter",(jsonactivity.mostCurrent._adapter));
 BA.debugLineNum = 47;BA.debugLine="LV.CacheColorHint = 0";
Debug.ShouldStop(16384);
jsonactivity.mostCurrent._lv.runVoidMethod ("setCacheColorHint",BA.numberCast(int.class, 0));
 BA.debugLineNum = 48;BA.debugLine="LV.DividerHeight = 5dip";
Debug.ShouldStop(32768);
jsonactivity.mostCurrent._lv.runMethod(true,"setDividerHeight",jsonactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))));
 BA.debugLineNum = 49;BA.debugLine="LV.FastScrollEnabled = True";
Debug.ShouldStop(65536);
jsonactivity.mostCurrent._lv.runVoidMethod ("setFastScrollEnabled",jsonactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (jsonactivity) ","jsonactivity",2,jsonactivity.mostCurrent.activityBA,jsonactivity.mostCurrent,57);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.jsonactivity.remoteMe.runUserSub(false, "jsonactivity","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (jsonactivity) ","jsonactivity",2,jsonactivity.mostCurrent.activityBA,jsonactivity.mostCurrent,53);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.jsonactivity.remoteMe.runUserSub(false, "jsonactivity","activity_resume");
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _adapter_onbindview(RemoteObject _position,RemoteObject _viewholder) throws Exception{
try {
		Debug.PushSubsStack("Adapter_onBindView (jsonactivity) ","jsonactivity",2,jsonactivity.mostCurrent.activityBA,jsonactivity.mostCurrent,121);
if (RapidSub.canDelegate("adapter_onbindview")) return b4a.example.jsonactivity.remoteMe.runUserSub(false, "jsonactivity","adapter_onbindview", _position, _viewholder);
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("position", _position);
Debug.locals.put("viewHolder", _viewholder);
 BA.debugLineNum = 121;BA.debugLine="Sub Adapter_onBindView(position As Int, viewHolder";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 123;BA.debugLine="Label1 = viewHolder.findViewById(10)";
Debug.ShouldStop(67108864);
jsonactivity.mostCurrent._label1.setObject(_viewholder.runMethod(false,"findViewById",(Object)(BA.numberCast(int.class, 10))));
 BA.debugLineNum = 124;BA.debugLine="Label2 = viewHolder.findViewById(20)";
Debug.ShouldStop(134217728);
jsonactivity.mostCurrent._label2.setObject(_viewholder.runMethod(false,"findViewById",(Object)(BA.numberCast(int.class, 20))));
 BA.debugLineNum = 125;BA.debugLine="Label3 = viewHolder.findViewById(30)";
Debug.ShouldStop(268435456);
jsonactivity.mostCurrent._label3.setObject(_viewholder.runMethod(false,"findViewById",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 126;BA.debugLine="ImageView1 = viewHolder.findViewById(40)";
Debug.ShouldStop(536870912);
jsonactivity.mostCurrent._imageview1.setObject(_viewholder.runMethod(false,"findViewById",(Object)(BA.numberCast(int.class, 40))));
 BA.debugLineNum = 129;BA.debugLine="Dim m As Map = Adapter.DataSource.Get(position)";
Debug.ShouldStop(1);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_m.setObject(jsonactivity.mostCurrent._adapter.runMethod(false,"getDataSource").runMethod(false,"Get",(Object)(_position)));Debug.locals.put("m", _m);
 BA.debugLineNum = 132;BA.debugLine="Label1.Text = (position+1) & \". \" & m.Get(\"app_na";
Debug.ShouldStop(8);
jsonactivity.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat((RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(1)}, "+",1, 1)),RemoteObject.createImmutable(". "),_m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("app_name")))))));
 BA.debugLineNum = 133;BA.debugLine="Label2.Text = m.GetDefault(\"app_version\", \"\")";
Debug.ShouldStop(16);
jsonactivity.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(_m.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("app_version"))),(Object)((RemoteObject.createImmutable(""))))));
 BA.debugLineNum = 134;BA.debugLine="Label3.Text = m.GetDefault(\"catch_phrase\", \"\")";
Debug.ShouldStop(32);
jsonactivity.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence(_m.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("catch_phrase"))),(Object)((RemoteObject.createImmutable(""))))));
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _adapter_ongetview(RemoteObject _position,RemoteObject _viewholder) throws Exception{
try {
		Debug.PushSubsStack("Adapter_onGetView (jsonactivity) ","jsonactivity",2,jsonactivity.mostCurrent.activityBA,jsonactivity.mostCurrent,72);
if (RapidSub.canDelegate("adapter_ongetview")) return b4a.example.jsonactivity.remoteMe.runUserSub(false, "jsonactivity","adapter_ongetview", _position, _viewholder);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _tf = RemoteObject.declareNull("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
Debug.locals.put("position", _position);
Debug.locals.put("viewHolder", _viewholder);
 BA.debugLineNum = 72;BA.debugLine="Sub Adapter_onGetView(position As Int, viewHolder";
Debug.ShouldStop(128);
 BA.debugLineNum = 74;BA.debugLine="If viewHolder.Container = Null Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("n",_viewholder.runMethod(false,"getContainer"))) { 
 BA.debugLineNum = 76;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(2048);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 77;BA.debugLine="p.Initialize(\"\")";
Debug.ShouldStop(4096);
_p.runVoidMethod ("Initialize",jsonactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 78;BA.debugLine="p.LoadLayout(\"Layout1\")";
Debug.ShouldStop(8192);
_p.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout1")),jsonactivity.mostCurrent.activityBA);
 BA.debugLineNum = 95;BA.debugLine="viewHolder.Initialize(p, 100dip, 100%x)";
Debug.ShouldStop(1073741824);
_viewholder.runVoidMethod ("Initialize",(Object)((_p.getObject())),(Object)(jsonactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(jsonactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),jsonactivity.mostCurrent.activityBA)));
 BA.debugLineNum = 96;BA.debugLine="viewHolder.setViewId(Label1, 10)";
Debug.ShouldStop(-2147483648);
_viewholder.runVoidMethod ("setViewId",(Object)((jsonactivity.mostCurrent._label1.getObject())),(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 97;BA.debugLine="viewHolder.setViewId(Label2, 20)";
Debug.ShouldStop(1);
_viewholder.runVoidMethod ("setViewId",(Object)((jsonactivity.mostCurrent._label2.getObject())),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 98;BA.debugLine="viewHolder.setViewId(Label3, 30)";
Debug.ShouldStop(2);
_viewholder.runVoidMethod ("setViewId",(Object)((jsonactivity.mostCurrent._label3.getObject())),(Object)(BA.numberCast(int.class, 30)));
 BA.debugLineNum = 99;BA.debugLine="viewHolder.setViewId(ImageView1, 40)";
Debug.ShouldStop(4);
_viewholder.runVoidMethod ("setViewId",(Object)((jsonactivity.mostCurrent._imageview1.getObject())),(Object)(BA.numberCast(int.class, 40)));
 BA.debugLineNum = 102;BA.debugLine="Label1.TextColor = Colors.Black";
Debug.ShouldStop(32);
jsonactivity.mostCurrent._label1.runMethod(true,"setTextColor",jsonactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 103;BA.debugLine="Dim tf As Typeface = Typeface.LoadFromAssets(\"jo";
Debug.ShouldStop(64);
_tf = RemoteObject.createNew ("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
_tf.setObject(jsonactivity.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("josefinsans-bold.ttf"))));Debug.locals.put("tf", _tf);
 BA.debugLineNum = 104;BA.debugLine="Label3.Typeface = tf.DEFAULT_BOLD";
Debug.ShouldStop(128);
jsonactivity.mostCurrent._label3.runMethod(false,"setTypeface",_tf.getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 106;BA.debugLine="Label1.Width = -2 '100%x - Label1.Left - 10dip";
Debug.ShouldStop(512);
jsonactivity.mostCurrent._label1.runMethod(true,"setWidth",BA.numberCast(int.class, -(double) (0 + 2)));
 BA.debugLineNum = 107;BA.debugLine="Label2.Width = 100dip";
Debug.ShouldStop(1024);
jsonactivity.mostCurrent._label2.runMethod(true,"setWidth",jsonactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));
 BA.debugLineNum = 108;BA.debugLine="Label2.SetLayout(100%x - Label2.Width - 10dip, 5";
Debug.ShouldStop(2048);
jsonactivity.mostCurrent._label2.runVoidMethod ("SetLayout",(Object)(RemoteObject.solve(new RemoteObject[] {jsonactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),jsonactivity.mostCurrent.activityBA),jsonactivity.mostCurrent._label2.runMethod(true,"getWidth"),jsonactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "--",2, 1)),(Object)(jsonactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(jsonactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(BA.numberCast(int.class, -(double) (0 + 2))));
 BA.debugLineNum = 109;BA.debugLine="Label3.Width = 100%x - Label1.Left - 10dip";
Debug.ShouldStop(4096);
jsonactivity.mostCurrent._label3.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {jsonactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),jsonactivity.mostCurrent.activityBA),jsonactivity.mostCurrent._label1.runMethod(true,"getLeft"),jsonactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "--",2, 1));
 BA.debugLineNum = 110;BA.debugLine="tf = Typeface.LoadFromAssets(\"josefinsans-semibo";
Debug.ShouldStop(8192);
_tf.setObject(jsonactivity.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("josefinsans-semibolditalic.ttf"))));
 BA.debugLineNum = 111;BA.debugLine="Label3.Typeface = tf";
Debug.ShouldStop(16384);
jsonactivity.mostCurrent._label3.runMethod(false,"setTypeface",(_tf.getObject()));
 BA.debugLineNum = 113;BA.debugLine="Dim cd As GradientDrawable";
Debug.ShouldStop(65536);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 114;BA.debugLine="cd.Initialize(\"TOP_BOTTOM\", Array As Int(Colors.";
Debug.ShouldStop(131072);
_cd.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {jsonactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray"),jsonactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"White")})));
 BA.debugLineNum = 115;BA.debugLine="cd.CornerRadius = 20dip";
Debug.ShouldStop(262144);
_cd.runVoidMethod ("setCornerRadius",BA.numberCast(float.class, jsonactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 116;BA.debugLine="Label2.Background = cd";
Debug.ShouldStop(524288);
jsonactivity.mostCurrent._label2.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 117;BA.debugLine="Label2.Gravity = Gravity.CENTER";
Debug.ShouldStop(1048576);
jsonactivity.mostCurrent._label2.runMethod(true,"setGravity",jsonactivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 };
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private Label1 As Label";
jsonactivity.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private Label3 As Label";
jsonactivity.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private Label2 As Label";
jsonactivity.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private ImageView1 As ImageView";
jsonactivity.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim LV As JSListView2";
jsonactivity.mostCurrent._lv = RemoteObject.createNew ("com.salvadorjhai.widgets.JSListView2");
 //BA.debugLineNum = 21;BA.debugLine="Dim Adapter As JSListAdapter";
jsonactivity.mostCurrent._adapter = RemoteObject.createNew ("com.salvadorjhai.data.JSListAdapter");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lv_onitemclick(RemoteObject _view,RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("LV_OnItemClick (jsonactivity) ","jsonactivity",2,jsonactivity.mostCurrent.activityBA,jsonactivity.mostCurrent,137);
if (RapidSub.canDelegate("lv_onitemclick")) return b4a.example.jsonactivity.remoteMe.runUserSub(false, "jsonactivity","lv_onitemclick", _view, _position);
Debug.locals.put("view", _view);
Debug.locals.put("position", _position);
 BA.debugLineNum = 137;BA.debugLine="Sub LV_OnItemClick(view As JSViewHolder, position";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="ToastMessageShow($\"Position ${position}\"$, False)";
Debug.ShouldStop(512);
jsonactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("Position "),jsonactivity.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_position))),RemoteObject.createImmutable(""))))),(Object)(jsonactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mnuadd_click() throws Exception{
try {
		Debug.PushSubsStack("mnuAdd_Click (jsonactivity) ","jsonactivity",2,jsonactivity.mostCurrent.activityBA,jsonactivity.mostCurrent,61);
if (RapidSub.canDelegate("mnuadd_click")) return b4a.example.jsonactivity.remoteMe.runUserSub(false, "jsonactivity","mnuadd_click");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 61;BA.debugLine="Sub mnuAdd_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 62;BA.debugLine="Dim m As Map";
Debug.ShouldStop(536870912);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 63;BA.debugLine="m.Initialize";
Debug.ShouldStop(1073741824);
_m.runVoidMethod ("Initialize");
 BA.debugLineNum = 64;BA.debugLine="m.Put(\"app_name\", DateTime.Now)";
Debug.ShouldStop(-2147483648);
_m.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("app_name"))),(Object)((jsonactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 65;BA.debugLine="m.Put(\"app_version\", \"test\")";
Debug.ShouldStop(1);
_m.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("app_version"))),(Object)((RemoteObject.createImmutable("test"))));
 BA.debugLineNum = 66;BA.debugLine="m.Put(\"catch_phrase\", \"12345789\")";
Debug.ShouldStop(2);
_m.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("catch_phrase"))),(Object)((RemoteObject.createImmutable("12345789"))));
 BA.debugLineNum = 67;BA.debugLine="Adapter.ItemAdd(m)";
Debug.ShouldStop(4);
jsonactivity.mostCurrent._adapter.runVoidMethod ("ItemAdd",(Object)((_m.getObject())));
 BA.debugLineNum = 68;BA.debugLine="LV.Selection = Adapter.Count";
Debug.ShouldStop(8);
jsonactivity.mostCurrent._lv.runVoidMethod ("setSelection",jsonactivity.mostCurrent._adapter.runMethod(true,"getCount"));
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}