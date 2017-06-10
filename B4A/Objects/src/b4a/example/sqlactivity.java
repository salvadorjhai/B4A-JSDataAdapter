package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class sqlactivity extends Activity implements B4AActivity{
	public static sqlactivity mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.sqlactivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (sqlactivity).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.sqlactivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.sqlactivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (sqlactivity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (sqlactivity) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return sqlactivity.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (sqlactivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (sqlactivity) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static com.salvadorjhai.JSSQLiteDatabase _cn = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public com.salvadorjhai.widgets.JSListView2 _lv = null;
public static int _pos = 0;
public com.salvadorjhai.data.JSCursorAdapter _adapter = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.jsonactivity _jsonactivity = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="sqlactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
com.salvadorjhai.JSSQLiteDatabase.CursorWrapper _cur = null;
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Activity.Title = \"JSCursorAdapter (Cursor)\"";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("JSCursorAdapter (Cursor)"));
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="Activity.AddMenuItem(\"Add\", \"mnuAdd\")";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("Add"),"mnuAdd");
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="If File.Exists(File.DirInternal, \"1.db\") = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"1.db")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1572871;
 //BA.debugLineNum = 1572871;BA.debugLine="File.Copy(File.DirAssets, \"1.db\", File.DirIntern";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"1.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"1.db");
 };
RDebugUtils.currentLine=1572875;
 //BA.debugLineNum = 1572875;BA.debugLine="cn.Initialize(File.DirInternal, \"1.db\", False)";
_cn.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"1.db",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="Dim cur As Cursor = cn.ExecQuery(\"SELECT * FROM M";
_cur = new com.salvadorjhai.JSSQLiteDatabase.CursorWrapper();
_cur.setObject((android.database.Cursor)(_cn.ExecQuery("SELECT * FROM MOCK_DATA")));
RDebugUtils.currentLine=1572879;
 //BA.debugLineNum = 1572879;BA.debugLine="Adapter.Initialize(\"Adapter\", cur)";
mostCurrent._adapter.Initialize(processBA,"Adapter",(android.database.Cursor)(_cur.getObject()));
RDebugUtils.currentLine=1572882;
 //BA.debugLineNum = 1572882;BA.debugLine="LV.Initialize(\"LV\")";
mostCurrent._lv.Initialize(mostCurrent.activityBA,"LV");
RDebugUtils.currentLine=1572883;
 //BA.debugLineNum = 1572883;BA.debugLine="Activity.AddView(LV, 0dip, 0dip, 100%x, 100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._lv.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=1572884;
 //BA.debugLineNum = 1572884;BA.debugLine="LV.Adapter = Adapter";
mostCurrent._lv.setAdapter((Object)(mostCurrent._adapter));
RDebugUtils.currentLine=1572887;
 //BA.debugLineNum = 1572887;BA.debugLine="LV.CacheColorHint = 0";
mostCurrent._lv.setCacheColorHint((int) (0));
RDebugUtils.currentLine=1572888;
 //BA.debugLineNum = 1572888;BA.debugLine="LV.DividerHeight = 1";
mostCurrent._lv.setDividerHeight((int) (1));
RDebugUtils.currentLine=1572889;
 //BA.debugLineNum = 1572889;BA.debugLine="LV.FastScrollEnabled = True";
mostCurrent._lv.setFastScrollEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572890;
 //BA.debugLineNum = 1572890;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="sqlactivity";
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="If UserClosed Then cn.Close";
if (_userclosed) { 
_cn.Close();};
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="sqlactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="End Sub";
return "";
}
public static String  _adapter_onbindview(int _position,com.salvadorjhai.data.JSViewHolder _viewholder) throws Exception{
RDebugUtils.currentModule="sqlactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "adapter_onbindview"))
	return (String) Debug.delegate(mostCurrent.activityBA, "adapter_onbindview", new Object[] {_position,_viewholder});
com.salvadorjhai.JSSQLiteDatabase.CursorWrapper _m = null;
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub Adapter_onBindView(Position As Int, viewHolder";
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="Label1 = viewHolder.findViewById(10)";
mostCurrent._label1.setObject((android.widget.TextView)(_viewholder.findViewById((int) (10))));
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="Label2 = viewHolder.findViewById(20)";
mostCurrent._label2.setObject((android.widget.TextView)(_viewholder.findViewById((int) (20))));
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Label3 = viewHolder.findViewById(30)";
mostCurrent._label3.setObject((android.widget.TextView)(_viewholder.findViewById((int) (30))));
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="ImageView1 = viewHolder.findViewById(40)";
mostCurrent._imageview1.setObject((android.widget.ImageView)(_viewholder.findViewById((int) (40))));
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="Dim m As Cursor = Adapter.DataSource";
_m = new com.salvadorjhai.JSSQLiteDatabase.CursorWrapper();
_m.setObject((android.database.Cursor)(mostCurrent._adapter.getDataSource()));
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="m.Position = Position";
_m.setPosition(_position);
RDebugUtils.currentLine=1900556;
 //BA.debugLineNum = 1900556;BA.debugLine="Label1.Text = (Position+1) & \". \" & m.GetString(\"";
mostCurrent._label1.setText(BA.ObjectToCharSequence(BA.NumberToString((_position+1))+". "+_m.GetString("app_name")));
RDebugUtils.currentLine=1900557;
 //BA.debugLineNum = 1900557;BA.debugLine="Label2.Text = m.GetString(\"app_version\")";
mostCurrent._label2.setText(BA.ObjectToCharSequence(_m.GetString("app_version")));
RDebugUtils.currentLine=1900558;
 //BA.debugLineNum = 1900558;BA.debugLine="Label3.Text = m.GetString(\"catch_phrase\")";
mostCurrent._label3.setText(BA.ObjectToCharSequence(_m.GetString("catch_phrase")));
RDebugUtils.currentLine=1900561;
 //BA.debugLineNum = 1900561;BA.debugLine="Label1.TextColor = Colors.Red";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1900562;
 //BA.debugLineNum = 1900562;BA.debugLine="If Label2.Text= \"10\" Then";
if ((mostCurrent._label2.getText()).equals("10")) { 
RDebugUtils.currentLine=1900563;
 //BA.debugLineNum = 1900563;BA.debugLine="Label1.TextColor = Colors.Blue";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 };
RDebugUtils.currentLine=1900566;
 //BA.debugLineNum = 1900566;BA.debugLine="End Sub";
return "";
}
public static String  _adapter_ongetview(int _position,com.salvadorjhai.data.JSViewHolder _viewholder) throws Exception{
RDebugUtils.currentModule="sqlactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "adapter_ongetview"))
	return (String) Debug.delegate(mostCurrent.activityBA, "adapter_ongetview", new Object[] {_position,_viewholder});
anywheresoftware.b4a.objects.PanelWrapper _p = null;
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub Adapter_onGetView(Position As Int, viewHolder";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="If viewHolder.Container = Null Then";
if (_viewholder.getContainer()== null) { 
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="p.Initialize(\"\")";
_p.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="p.LoadLayout(\"Layout1\")";
_p.LoadLayout("Layout1",mostCurrent.activityBA);
RDebugUtils.currentLine=1835017;
 //BA.debugLineNum = 1835017;BA.debugLine="viewHolder.Initialize(p, 100dip, 100%x)";
_viewholder.Initialize((android.view.ViewGroup)(_p.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=1835018;
 //BA.debugLineNum = 1835018;BA.debugLine="viewHolder.setViewId(Label1, 10)";
_viewholder.setViewId((android.view.View)(mostCurrent._label1.getObject()),(int) (10));
RDebugUtils.currentLine=1835019;
 //BA.debugLineNum = 1835019;BA.debugLine="viewHolder.setViewId(Label2, 20)";
_viewholder.setViewId((android.view.View)(mostCurrent._label2.getObject()),(int) (20));
RDebugUtils.currentLine=1835020;
 //BA.debugLineNum = 1835020;BA.debugLine="viewHolder.setViewId(Label3, 30)";
_viewholder.setViewId((android.view.View)(mostCurrent._label3.getObject()),(int) (30));
RDebugUtils.currentLine=1835021;
 //BA.debugLineNum = 1835021;BA.debugLine="viewHolder.setViewId(ImageView1, 40)";
_viewholder.setViewId((android.view.View)(mostCurrent._imageview1.getObject()),(int) (40));
RDebugUtils.currentLine=1835024;
 //BA.debugLineNum = 1835024;BA.debugLine="Label1.Width = 100%x";
mostCurrent._label1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=1835025;
 //BA.debugLineNum = 1835025;BA.debugLine="Label2.Width = 100%x";
mostCurrent._label2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=1835026;
 //BA.debugLineNum = 1835026;BA.debugLine="Label3.Width = 100%x";
mostCurrent._label3.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 };
RDebugUtils.currentLine=1835028;
 //BA.debugLineNum = 1835028;BA.debugLine="pos=Position";
_pos = _position;
RDebugUtils.currentLine=1835029;
 //BA.debugLineNum = 1835029;BA.debugLine="End Sub";
return "";
}
public static String  _lv_onitemlongclick(com.salvadorjhai.data.JSViewHolder _view,int _position) throws Exception{
RDebugUtils.currentModule="sqlactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lv_onitemlongclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "lv_onitemlongclick", new Object[] {_view,_position});
com.salvadorjhai.JSSQLiteDatabase.CursorWrapper _cur = null;
com.salvadorjhai.ContentValuesWrapper _m = null;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub LV_OnItemLongClick(view As JSViewHolder, posit";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="If position < 0 Then Return";
if (_position<0) { 
if (true) return "";};
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="Dim cur As Cursor = Adapter.DataSource";
_cur = new com.salvadorjhai.JSSQLiteDatabase.CursorWrapper();
_cur.setObject((android.database.Cursor)(mostCurrent._adapter.getDataSource()));
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="cur.Position = position";
_cur.setPosition(_position);
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="Dim m As ContentValues = cn.CursorRowToContentVal";
_m = new com.salvadorjhai.ContentValuesWrapper();
_m.setObject((android.content.ContentValues)(_cn.CursorRowToContentValues((android.database.Cursor)(_cur.getObject()))));
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="m.Remove(\"id\")";
_m.Remove("id");
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="m.PutString(\"app_name\", \"Updated: \" & DateTime.No";
_m.PutString("app_name","Updated: "+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=1966089;
 //BA.debugLineNum = 1966089;BA.debugLine="m.PutString(\"app_version\", \"10\")";
_m.PutString("app_version","10");
RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="m.PutString(\"catch_phrase\", \"12345789\")";
_m.PutString("catch_phrase","12345789");
RDebugUtils.currentLine=1966091;
 //BA.debugLineNum = 1966091;BA.debugLine="cn.ExecUpdate(\"MOCK_DATA\", m, \"rowid = ?\", Array";
_cn.ExecUpdate("MOCK_DATA",(android.content.ContentValues)(_m.getObject()),"rowid = ?",new String[]{BA.NumberToString(_position+1)});
RDebugUtils.currentLine=1966094;
 //BA.debugLineNum = 1966094;BA.debugLine="Dim cur As Cursor = cn.ExecQuery(\"SELECT * FROM M";
_cur = new com.salvadorjhai.JSSQLiteDatabase.CursorWrapper();
_cur.setObject((android.database.Cursor)(_cn.ExecQuery("SELECT * FROM MOCK_DATA")));
RDebugUtils.currentLine=1966095;
 //BA.debugLineNum = 1966095;BA.debugLine="Adapter.Initialize(\"Adapter\", cur)";
mostCurrent._adapter.Initialize(processBA,"Adapter",(android.database.Cursor)(_cur.getObject()));
RDebugUtils.currentLine=1966096;
 //BA.debugLineNum = 1966096;BA.debugLine="LV.Adapter = Adapter";
mostCurrent._lv.setAdapter((Object)(mostCurrent._adapter));
RDebugUtils.currentLine=1966097;
 //BA.debugLineNum = 1966097;BA.debugLine="LV.Selection = position";
mostCurrent._lv.setSelection(_position);
RDebugUtils.currentLine=1966099;
 //BA.debugLineNum = 1966099;BA.debugLine="End Sub";
return "";
}
public static String  _mnuadd_click() throws Exception{
RDebugUtils.currentModule="sqlactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mnuadd_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mnuadd_click", null);
com.salvadorjhai.ContentValuesWrapper _m = null;
com.salvadorjhai.JSSQLiteDatabase.CursorWrapper _cur = null;
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub mnuAdd_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Dim m As ContentValues";
_m = new com.salvadorjhai.ContentValuesWrapper();
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="m.Initialize";
_m.Initialize();
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="m.PutString(\"app_name\", DateTime.Now)";
_m.PutString("app_name",BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="m.PutString(\"app_version\", \"test\")";
_m.PutString("app_version","test");
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="m.PutString(\"catch_phrase\", \"12345789\")";
_m.PutString("catch_phrase","12345789");
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="cn.ExecInsert(\"MOCK_DATA\", \"\", m)";
_cn.ExecInsert("MOCK_DATA","",(android.content.ContentValues)(_m.getObject()));
RDebugUtils.currentLine=1769480;
 //BA.debugLineNum = 1769480;BA.debugLine="Dim cur As Cursor = cn.ExecQuery(\"SELECT * FROM M";
_cur = new com.salvadorjhai.JSSQLiteDatabase.CursorWrapper();
_cur.setObject((android.database.Cursor)(_cn.ExecQuery("SELECT * FROM MOCK_DATA")));
RDebugUtils.currentLine=1769481;
 //BA.debugLineNum = 1769481;BA.debugLine="Adapter.Initialize(\"Adapter\", cur)";
mostCurrent._adapter.Initialize(processBA,"Adapter",(android.database.Cursor)(_cur.getObject()));
RDebugUtils.currentLine=1769482;
 //BA.debugLineNum = 1769482;BA.debugLine="LV.Adapter = Adapter";
mostCurrent._lv.setAdapter((Object)(mostCurrent._adapter));
RDebugUtils.currentLine=1769483;
 //BA.debugLineNum = 1769483;BA.debugLine="LV.Selection = Adapter.Count";
mostCurrent._lv.setSelection(mostCurrent._adapter.getCount());
RDebugUtils.currentLine=1769484;
 //BA.debugLineNum = 1769484;BA.debugLine="End Sub";
return "";
}
}