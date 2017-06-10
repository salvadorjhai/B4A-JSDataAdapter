package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class sqlactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (sqlactivity) ","sqlactivity",3,sqlactivity.mostCurrent.activityBA,sqlactivity.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) return b4a.example.sqlactivity.remoteMe.runUserSub(false, "sqlactivity","activity_create", _firsttime);
RemoteObject _cur = RemoteObject.declareNull("com.salvadorjhai.JSSQLiteDatabase.CursorWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 28;BA.debugLine="Activity.Title = \"JSCursorAdapter (Cursor)\"";
Debug.ShouldStop(134217728);
sqlactivity.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("JSCursorAdapter (Cursor)"));
 BA.debugLineNum = 29;BA.debugLine="Activity.AddMenuItem(\"Add\", \"mnuAdd\")";
Debug.ShouldStop(268435456);
sqlactivity.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToCharSequence("Add")),(Object)(RemoteObject.createImmutable("mnuAdd")));
 BA.debugLineNum = 31;BA.debugLine="If File.Exists(File.DirInternal, \"1.db\") = False";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",sqlactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(sqlactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("1.db"))),sqlactivity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 32;BA.debugLine="File.Copy(File.DirAssets, \"1.db\", File.DirIntern";
Debug.ShouldStop(-2147483648);
sqlactivity.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(sqlactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("1.db")),(Object)(sqlactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("1.db")));
 };
 BA.debugLineNum = 36;BA.debugLine="cn.Initialize(File.DirInternal, \"1.db\", False)";
Debug.ShouldStop(8);
sqlactivity._cn.runVoidMethod ("Initialize",(Object)(sqlactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("1.db")),(Object)(sqlactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 37;BA.debugLine="Dim cur As Cursor = cn.ExecQuery(\"SELECT * FROM M";
Debug.ShouldStop(16);
_cur = RemoteObject.createNew ("com.salvadorjhai.JSSQLiteDatabase.CursorWrapper");
_cur.setObject(sqlactivity._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM MOCK_DATA"))));Debug.locals.put("cur", _cur);
 BA.debugLineNum = 40;BA.debugLine="Adapter.Initialize(\"Adapter\", cur)";
Debug.ShouldStop(128);
sqlactivity.mostCurrent._adapter.runVoidMethod ("Initialize",sqlactivity.processBA,(Object)(BA.ObjectToString("Adapter")),(Object)((_cur.getObject())));
 BA.debugLineNum = 43;BA.debugLine="LV.Initialize(\"LV\")";
Debug.ShouldStop(1024);
sqlactivity.mostCurrent._lv.runVoidMethod ("Initialize",sqlactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("LV")));
 BA.debugLineNum = 44;BA.debugLine="Activity.AddView(LV, 0dip, 0dip, 100%x, 100%y)";
Debug.ShouldStop(2048);
sqlactivity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((sqlactivity.mostCurrent._lv.getObject())),(Object)(sqlactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(sqlactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(sqlactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),sqlactivity.mostCurrent.activityBA)),(Object)(sqlactivity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),sqlactivity.mostCurrent.activityBA)));
 BA.debugLineNum = 45;BA.debugLine="LV.Adapter = Adapter";
Debug.ShouldStop(4096);
sqlactivity.mostCurrent._lv.runMethod(false,"setAdapter",(sqlactivity.mostCurrent._adapter));
 BA.debugLineNum = 48;BA.debugLine="LV.CacheColorHint = 0";
Debug.ShouldStop(32768);
sqlactivity.mostCurrent._lv.runVoidMethod ("setCacheColorHint",BA.numberCast(int.class, 0));
 BA.debugLineNum = 49;BA.debugLine="LV.DividerHeight = 1";
Debug.ShouldStop(65536);
sqlactivity.mostCurrent._lv.runMethod(true,"setDividerHeight",BA.numberCast(int.class, 1));
 BA.debugLineNum = 50;BA.debugLine="LV.FastScrollEnabled = True";
Debug.ShouldStop(131072);
sqlactivity.mostCurrent._lv.runVoidMethod ("setFastScrollEnabled",sqlactivity.mostCurrent.__c.getField(true,"True"));
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
		Debug.PushSubsStack("Activity_Pause (sqlactivity) ","sqlactivity",3,sqlactivity.mostCurrent.activityBA,sqlactivity.mostCurrent,57);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.sqlactivity.remoteMe.runUserSub(false, "sqlactivity","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="If UserClosed Then cn.Close";
Debug.ShouldStop(33554432);
if (_userclosed.<Boolean>get().booleanValue()) { 
sqlactivity._cn.runVoidMethod ("Close");};
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
		Debug.PushSubsStack("Activity_Resume (sqlactivity) ","sqlactivity",3,sqlactivity.mostCurrent.activityBA,sqlactivity.mostCurrent,53);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.sqlactivity.remoteMe.runUserSub(false, "sqlactivity","activity_resume");
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
		Debug.PushSubsStack("Adapter_onBindView (sqlactivity) ","sqlactivity",3,sqlactivity.mostCurrent.activityBA,sqlactivity.mostCurrent,99);
if (RapidSub.canDelegate("adapter_onbindview")) return b4a.example.sqlactivity.remoteMe.runUserSub(false, "sqlactivity","adapter_onbindview", _position, _viewholder);
RemoteObject _m = RemoteObject.declareNull("com.salvadorjhai.JSSQLiteDatabase.CursorWrapper");
Debug.locals.put("Position", _position);
Debug.locals.put("viewHolder", _viewholder);
 BA.debugLineNum = 99;BA.debugLine="Sub Adapter_onBindView(Position As Int, viewHolder";
Debug.ShouldStop(4);
 BA.debugLineNum = 101;BA.debugLine="Label1 = viewHolder.findViewById(10)";
Debug.ShouldStop(16);
sqlactivity.mostCurrent._label1.setObject(_viewholder.runMethod(false,"findViewById",(Object)(BA.numberCast(int.class, 10))));
 BA.debugLineNum = 102;BA.debugLine="Label2 = viewHolder.findViewById(20)";
Debug.ShouldStop(32);
sqlactivity.mostCurrent._label2.setObject(_viewholder.runMethod(false,"findViewById",(Object)(BA.numberCast(int.class, 20))));
 BA.debugLineNum = 103;BA.debugLine="Label3 = viewHolder.findViewById(30)";
Debug.ShouldStop(64);
sqlactivity.mostCurrent._label3.setObject(_viewholder.runMethod(false,"findViewById",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 104;BA.debugLine="ImageView1 = viewHolder.findViewById(40)";
Debug.ShouldStop(128);
sqlactivity.mostCurrent._imageview1.setObject(_viewholder.runMethod(false,"findViewById",(Object)(BA.numberCast(int.class, 40))));
 BA.debugLineNum = 107;BA.debugLine="Dim m As Cursor = Adapter.DataSource";
Debug.ShouldStop(1024);
_m = RemoteObject.createNew ("com.salvadorjhai.JSSQLiteDatabase.CursorWrapper");
_m.setObject(sqlactivity.mostCurrent._adapter.runMethod(false,"getDataSource"));Debug.locals.put("m", _m);
 BA.debugLineNum = 108;BA.debugLine="m.Position = Position";
Debug.ShouldStop(2048);
_m.runMethod(true,"setPosition",_position);
 BA.debugLineNum = 111;BA.debugLine="Label1.Text = (Position+1) & \". \" & m.GetString(\"";
Debug.ShouldStop(16384);
sqlactivity.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat((RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(1)}, "+",1, 1)),RemoteObject.createImmutable(". "),_m.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("app_name"))))));
 BA.debugLineNum = 112;BA.debugLine="Label2.Text = m.GetString(\"app_version\")";
Debug.ShouldStop(32768);
sqlactivity.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(_m.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("app_version")))));
 BA.debugLineNum = 113;BA.debugLine="Label3.Text = m.GetString(\"catch_phrase\")";
Debug.ShouldStop(65536);
sqlactivity.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence(_m.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("catch_phrase")))));
 BA.debugLineNum = 116;BA.debugLine="Label1.TextColor = Colors.Red";
Debug.ShouldStop(524288);
sqlactivity.mostCurrent._label1.runMethod(true,"setTextColor",sqlactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 117;BA.debugLine="If Label2.Text= \"10\" Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",sqlactivity.mostCurrent._label2.runMethod(true,"getText"),BA.ObjectToString("10"))) { 
 BA.debugLineNum = 118;BA.debugLine="Label1.TextColor = Colors.Blue";
Debug.ShouldStop(2097152);
sqlactivity.mostCurrent._label1.runMethod(true,"setTextColor",sqlactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 };
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Adapter_onGetView (sqlactivity) ","sqlactivity",3,sqlactivity.mostCurrent.activityBA,sqlactivity.mostCurrent,76);
if (RapidSub.canDelegate("adapter_ongetview")) return b4a.example.sqlactivity.remoteMe.runUserSub(false, "sqlactivity","adapter_ongetview", _position, _viewholder);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("Position", _position);
Debug.locals.put("viewHolder", _viewholder);
 BA.debugLineNum = 76;BA.debugLine="Sub Adapter_onGetView(Position As Int, viewHolder";
Debug.ShouldStop(2048);
 BA.debugLineNum = 78;BA.debugLine="If viewHolder.Container = Null Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("n",_viewholder.runMethod(false,"getContainer"))) { 
 BA.debugLineNum = 80;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(32768);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 81;BA.debugLine="p.Initialize(\"\")";
Debug.ShouldStop(65536);
_p.runVoidMethod ("Initialize",sqlactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 82;BA.debugLine="p.LoadLayout(\"Layout1\")";
Debug.ShouldStop(131072);
_p.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout1")),sqlactivity.mostCurrent.activityBA);
 BA.debugLineNum = 85;BA.debugLine="viewHolder.Initialize(p, 100dip, 100%x)";
Debug.ShouldStop(1048576);
_viewholder.runVoidMethod ("Initialize",(Object)((_p.getObject())),(Object)(sqlactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(sqlactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),sqlactivity.mostCurrent.activityBA)));
 BA.debugLineNum = 86;BA.debugLine="viewHolder.setViewId(Label1, 10)";
Debug.ShouldStop(2097152);
_viewholder.runVoidMethod ("setViewId",(Object)((sqlactivity.mostCurrent._label1.getObject())),(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 87;BA.debugLine="viewHolder.setViewId(Label2, 20)";
Debug.ShouldStop(4194304);
_viewholder.runVoidMethod ("setViewId",(Object)((sqlactivity.mostCurrent._label2.getObject())),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 88;BA.debugLine="viewHolder.setViewId(Label3, 30)";
Debug.ShouldStop(8388608);
_viewholder.runVoidMethod ("setViewId",(Object)((sqlactivity.mostCurrent._label3.getObject())),(Object)(BA.numberCast(int.class, 30)));
 BA.debugLineNum = 89;BA.debugLine="viewHolder.setViewId(ImageView1, 40)";
Debug.ShouldStop(16777216);
_viewholder.runVoidMethod ("setViewId",(Object)((sqlactivity.mostCurrent._imageview1.getObject())),(Object)(BA.numberCast(int.class, 40)));
 BA.debugLineNum = 92;BA.debugLine="Label1.Width = 100%x";
Debug.ShouldStop(134217728);
sqlactivity.mostCurrent._label1.runMethod(true,"setWidth",sqlactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),sqlactivity.mostCurrent.activityBA));
 BA.debugLineNum = 93;BA.debugLine="Label2.Width = 100%x";
Debug.ShouldStop(268435456);
sqlactivity.mostCurrent._label2.runMethod(true,"setWidth",sqlactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),sqlactivity.mostCurrent.activityBA));
 BA.debugLineNum = 94;BA.debugLine="Label3.Width = 100%x";
Debug.ShouldStop(536870912);
sqlactivity.mostCurrent._label3.runMethod(true,"setWidth",sqlactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),sqlactivity.mostCurrent.activityBA));
 };
 BA.debugLineNum = 96;BA.debugLine="pos=Position";
Debug.ShouldStop(-2147483648);
sqlactivity._pos = _position;
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
sqlactivity.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private Label3 As Label";
sqlactivity.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private Label2 As Label";
sqlactivity.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private ImageView1 As ImageView";
sqlactivity.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim LV As JSListView2";
sqlactivity.mostCurrent._lv = RemoteObject.createNew ("com.salvadorjhai.widgets.JSListView2");
 //BA.debugLineNum = 21;BA.debugLine="Dim pos As Int = 0";
sqlactivity._pos = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 22;BA.debugLine="Dim Adapter As JSCursorAdapter";
sqlactivity.mostCurrent._adapter = RemoteObject.createNew ("com.salvadorjhai.data.JSCursorAdapter");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lv_onitemlongclick(RemoteObject _view,RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("LV_OnItemLongClick (sqlactivity) ","sqlactivity",3,sqlactivity.mostCurrent.activityBA,sqlactivity.mostCurrent,123);
if (RapidSub.canDelegate("lv_onitemlongclick")) return b4a.example.sqlactivity.remoteMe.runUserSub(false, "sqlactivity","lv_onitemlongclick", _view, _position);
RemoteObject _cur = RemoteObject.declareNull("com.salvadorjhai.JSSQLiteDatabase.CursorWrapper");
RemoteObject _m = RemoteObject.declareNull("com.salvadorjhai.ContentValuesWrapper");
Debug.locals.put("view", _view);
Debug.locals.put("position", _position);
 BA.debugLineNum = 123;BA.debugLine="Sub LV_OnItemLongClick(view As JSViewHolder, posit";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 124;BA.debugLine="If position < 0 Then Return";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("<",_position,BA.numberCast(double.class, 0))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 126;BA.debugLine="Dim cur As Cursor = Adapter.DataSource";
Debug.ShouldStop(536870912);
_cur = RemoteObject.createNew ("com.salvadorjhai.JSSQLiteDatabase.CursorWrapper");
_cur.setObject(sqlactivity.mostCurrent._adapter.runMethod(false,"getDataSource"));Debug.locals.put("cur", _cur);
 BA.debugLineNum = 127;BA.debugLine="cur.Position = position";
Debug.ShouldStop(1073741824);
_cur.runMethod(true,"setPosition",_position);
 BA.debugLineNum = 128;BA.debugLine="Dim m As ContentValues = cn.CursorRowToContentVal";
Debug.ShouldStop(-2147483648);
_m = RemoteObject.createNew ("com.salvadorjhai.ContentValuesWrapper");
_m.setObject(sqlactivity._cn.runMethod(false,"CursorRowToContentValues",(Object)((_cur.getObject()))));Debug.locals.put("m", _m);
 BA.debugLineNum = 130;BA.debugLine="m.Remove(\"id\")";
Debug.ShouldStop(2);
_m.runVoidMethod ("Remove",(Object)(RemoteObject.createImmutable("id")));
 BA.debugLineNum = 131;BA.debugLine="m.PutString(\"app_name\", \"Updated: \" & DateTime.No";
Debug.ShouldStop(4);
_m.runVoidMethod ("PutString",(Object)(BA.ObjectToString("app_name")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("Updated: "),sqlactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 132;BA.debugLine="m.PutString(\"app_version\", \"10\")";
Debug.ShouldStop(8);
_m.runVoidMethod ("PutString",(Object)(BA.ObjectToString("app_version")),(Object)(RemoteObject.createImmutable("10")));
 BA.debugLineNum = 133;BA.debugLine="m.PutString(\"catch_phrase\", \"12345789\")";
Debug.ShouldStop(16);
_m.runVoidMethod ("PutString",(Object)(BA.ObjectToString("catch_phrase")),(Object)(RemoteObject.createImmutable("12345789")));
 BA.debugLineNum = 134;BA.debugLine="cn.ExecUpdate(\"MOCK_DATA\", m, \"rowid = ?\", Array";
Debug.ShouldStop(32);
sqlactivity._cn.runVoidMethod ("ExecUpdate",(Object)(BA.ObjectToString("MOCK_DATA")),(Object)((_m.getObject())),(Object)(BA.ObjectToString("rowid = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(1)}, "+",1, 1))})));
 BA.debugLineNum = 137;BA.debugLine="Dim cur As Cursor = cn.ExecQuery(\"SELECT * FROM M";
Debug.ShouldStop(256);
_cur = RemoteObject.createNew ("com.salvadorjhai.JSSQLiteDatabase.CursorWrapper");
_cur.setObject(sqlactivity._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM MOCK_DATA"))));Debug.locals.put("cur", _cur);
 BA.debugLineNum = 138;BA.debugLine="Adapter.Initialize(\"Adapter\", cur)";
Debug.ShouldStop(512);
sqlactivity.mostCurrent._adapter.runVoidMethod ("Initialize",sqlactivity.processBA,(Object)(BA.ObjectToString("Adapter")),(Object)((_cur.getObject())));
 BA.debugLineNum = 139;BA.debugLine="LV.Adapter = Adapter";
Debug.ShouldStop(1024);
sqlactivity.mostCurrent._lv.runMethod(false,"setAdapter",(sqlactivity.mostCurrent._adapter));
 BA.debugLineNum = 140;BA.debugLine="LV.Selection = position";
Debug.ShouldStop(2048);
sqlactivity.mostCurrent._lv.runVoidMethod ("setSelection",_position);
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("mnuAdd_Click (sqlactivity) ","sqlactivity",3,sqlactivity.mostCurrent.activityBA,sqlactivity.mostCurrent,62);
if (RapidSub.canDelegate("mnuadd_click")) return b4a.example.sqlactivity.remoteMe.runUserSub(false, "sqlactivity","mnuadd_click");
RemoteObject _m = RemoteObject.declareNull("com.salvadorjhai.ContentValuesWrapper");
RemoteObject _cur = RemoteObject.declareNull("com.salvadorjhai.JSSQLiteDatabase.CursorWrapper");
 BA.debugLineNum = 62;BA.debugLine="Sub mnuAdd_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="Dim m As ContentValues";
Debug.ShouldStop(1073741824);
_m = RemoteObject.createNew ("com.salvadorjhai.ContentValuesWrapper");Debug.locals.put("m", _m);
 BA.debugLineNum = 64;BA.debugLine="m.Initialize";
Debug.ShouldStop(-2147483648);
_m.runVoidMethod ("Initialize");
 BA.debugLineNum = 65;BA.debugLine="m.PutString(\"app_name\", DateTime.Now)";
Debug.ShouldStop(1);
_m.runVoidMethod ("PutString",(Object)(BA.ObjectToString("app_name")),(Object)(BA.NumberToString(sqlactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 66;BA.debugLine="m.PutString(\"app_version\", \"test\")";
Debug.ShouldStop(2);
_m.runVoidMethod ("PutString",(Object)(BA.ObjectToString("app_version")),(Object)(RemoteObject.createImmutable("test")));
 BA.debugLineNum = 67;BA.debugLine="m.PutString(\"catch_phrase\", \"12345789\")";
Debug.ShouldStop(4);
_m.runVoidMethod ("PutString",(Object)(BA.ObjectToString("catch_phrase")),(Object)(RemoteObject.createImmutable("12345789")));
 BA.debugLineNum = 68;BA.debugLine="cn.ExecInsert(\"MOCK_DATA\", \"\", m)";
Debug.ShouldStop(8);
sqlactivity._cn.runVoidMethod ("ExecInsert",(Object)(BA.ObjectToString("MOCK_DATA")),(Object)(BA.ObjectToString("")),(Object)((_m.getObject())));
 BA.debugLineNum = 70;BA.debugLine="Dim cur As Cursor = cn.ExecQuery(\"SELECT * FROM M";
Debug.ShouldStop(32);
_cur = RemoteObject.createNew ("com.salvadorjhai.JSSQLiteDatabase.CursorWrapper");
_cur.setObject(sqlactivity._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM MOCK_DATA"))));Debug.locals.put("cur", _cur);
 BA.debugLineNum = 71;BA.debugLine="Adapter.Initialize(\"Adapter\", cur)";
Debug.ShouldStop(64);
sqlactivity.mostCurrent._adapter.runVoidMethod ("Initialize",sqlactivity.processBA,(Object)(BA.ObjectToString("Adapter")),(Object)((_cur.getObject())));
 BA.debugLineNum = 72;BA.debugLine="LV.Adapter = Adapter";
Debug.ShouldStop(128);
sqlactivity.mostCurrent._lv.runMethod(false,"setAdapter",(sqlactivity.mostCurrent._adapter));
 BA.debugLineNum = 73;BA.debugLine="LV.Selection = Adapter.Count";
Debug.ShouldStop(256);
sqlactivity.mostCurrent._lv.runVoidMethod ("setSelection",sqlactivity.mostCurrent._adapter.runMethod(true,"getCount"));
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim cn As SQL";
sqlactivity._cn = RemoteObject.createNew ("com.salvadorjhai.JSSQLiteDatabase");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}