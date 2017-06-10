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

public class jsonactivity extends Activity implements B4AActivity{
	public static jsonactivity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.jsonactivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (jsonactivity).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.jsonactivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.jsonactivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (jsonactivity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (jsonactivity) Resume **");
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
		return jsonactivity.class;
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
        BA.LogInfo("** Activity (jsonactivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (jsonactivity) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public com.salvadorjhai.widgets.JSListView2 _lv = null;
public com.salvadorjhai.data.JSListAdapter _adapter = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.sqlactivity _sqlactivity = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="jsonactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
anywheresoftware.b4a.objects.collections.JSONParser _js = null;
anywheresoftware.b4a.objects.collections.List _data = null;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="Activity.Title = \"JSListAdapter (ListAdapter)\"";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("JSListAdapter (ListAdapter)"));
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="Activity.AddMenuItem(\"Add\", \"mnuAdd\")";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("Add"),"mnuAdd");
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="Dim js As JSONParser";
_js = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="js.Initialize(File.ReadString(File.DirAssets, \"MO";
_js.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"MOCK_DATA.json"));
RDebugUtils.currentLine=983052;
 //BA.debugLineNum = 983052;BA.debugLine="Dim data As List =  js.NextArray";
_data = new anywheresoftware.b4a.objects.collections.List();
_data = _js.NextArray();
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="Adapter.Initialize(\"Adapter\", data)";
mostCurrent._adapter.Initialize(processBA,"Adapter",_data);
RDebugUtils.currentLine=983058;
 //BA.debugLineNum = 983058;BA.debugLine="LV.Initialize(\"LV\")";
mostCurrent._lv.Initialize(mostCurrent.activityBA,"LV");
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="Activity.AddView(LV, 0dip, 0dip, 100%x, 100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._lv.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=983060;
 //BA.debugLineNum = 983060;BA.debugLine="LV.Adapter = Adapter";
mostCurrent._lv.setAdapter((Object)(mostCurrent._adapter));
RDebugUtils.currentLine=983063;
 //BA.debugLineNum = 983063;BA.debugLine="LV.CacheColorHint = 0";
mostCurrent._lv.setCacheColorHint((int) (0));
RDebugUtils.currentLine=983064;
 //BA.debugLineNum = 983064;BA.debugLine="LV.DividerHeight = 5dip";
mostCurrent._lv.setDividerHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)));
RDebugUtils.currentLine=983065;
 //BA.debugLineNum = 983065;BA.debugLine="LV.FastScrollEnabled = True";
mostCurrent._lv.setFastScrollEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983067;
 //BA.debugLineNum = 983067;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="jsonactivity";
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="jsonactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return "";
}
public static String  _adapter_onbindview(int _position,com.salvadorjhai.data.JSViewHolder _viewholder) throws Exception{
RDebugUtils.currentModule="jsonactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "adapter_onbindview"))
	return (String) Debug.delegate(mostCurrent.activityBA, "adapter_onbindview", new Object[] {_position,_viewholder});
anywheresoftware.b4a.objects.collections.Map _m = null;
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub Adapter_onBindView(position As Int, viewHolder";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="Label1 = viewHolder.findViewById(10)";
mostCurrent._label1.setObject((android.widget.TextView)(_viewholder.findViewById((int) (10))));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="Label2 = viewHolder.findViewById(20)";
mostCurrent._label2.setObject((android.widget.TextView)(_viewholder.findViewById((int) (20))));
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="Label3 = viewHolder.findViewById(30)";
mostCurrent._label3.setObject((android.widget.TextView)(_viewholder.findViewById((int) (30))));
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="ImageView1 = viewHolder.findViewById(40)";
mostCurrent._imageview1.setObject((android.widget.ImageView)(_viewholder.findViewById((int) (40))));
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="Dim m As Map = Adapter.DataSource.Get(position)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(mostCurrent._adapter.getDataSource().Get(_position)));
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="Label1.Text = (position+1) & \". \" & m.Get(\"app_na";
mostCurrent._label1.setText(BA.ObjectToCharSequence(BA.NumberToString((_position+1))+". "+BA.ObjectToString(_m.Get((Object)("app_name")))));
RDebugUtils.currentLine=1310732;
 //BA.debugLineNum = 1310732;BA.debugLine="Label2.Text = m.GetDefault(\"app_version\", \"\")";
mostCurrent._label2.setText(BA.ObjectToCharSequence(_m.GetDefault((Object)("app_version"),(Object)(""))));
RDebugUtils.currentLine=1310733;
 //BA.debugLineNum = 1310733;BA.debugLine="Label3.Text = m.GetDefault(\"catch_phrase\", \"\")";
mostCurrent._label3.setText(BA.ObjectToCharSequence(_m.GetDefault((Object)("catch_phrase"),(Object)(""))));
RDebugUtils.currentLine=1310734;
 //BA.debugLineNum = 1310734;BA.debugLine="End Sub";
return "";
}
public static String  _adapter_ongetview(int _position,com.salvadorjhai.data.JSViewHolder _viewholder) throws Exception{
RDebugUtils.currentModule="jsonactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "adapter_ongetview"))
	return (String) Debug.delegate(mostCurrent.activityBA, "adapter_ongetview", new Object[] {_position,_viewholder});
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.keywords.constants.TypefaceWrapper _tf = null;
anywheresoftware.b4a.objects.drawable.GradientDrawable _cd = null;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Adapter_onGetView(position As Int, viewHolder";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="If viewHolder.Container = Null Then";
if (_viewholder.getContainer()== null) { 
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="p.Initialize(\"\")";
_p.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="p.LoadLayout(\"Layout1\")";
_p.LoadLayout("Layout1",mostCurrent.activityBA);
RDebugUtils.currentLine=1245207;
 //BA.debugLineNum = 1245207;BA.debugLine="viewHolder.Initialize(p, 100dip, 100%x)";
_viewholder.Initialize((android.view.ViewGroup)(_p.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=1245208;
 //BA.debugLineNum = 1245208;BA.debugLine="viewHolder.setViewId(Label1, 10)";
_viewholder.setViewId((android.view.View)(mostCurrent._label1.getObject()),(int) (10));
RDebugUtils.currentLine=1245209;
 //BA.debugLineNum = 1245209;BA.debugLine="viewHolder.setViewId(Label2, 20)";
_viewholder.setViewId((android.view.View)(mostCurrent._label2.getObject()),(int) (20));
RDebugUtils.currentLine=1245210;
 //BA.debugLineNum = 1245210;BA.debugLine="viewHolder.setViewId(Label3, 30)";
_viewholder.setViewId((android.view.View)(mostCurrent._label3.getObject()),(int) (30));
RDebugUtils.currentLine=1245211;
 //BA.debugLineNum = 1245211;BA.debugLine="viewHolder.setViewId(ImageView1, 40)";
_viewholder.setViewId((android.view.View)(mostCurrent._imageview1.getObject()),(int) (40));
RDebugUtils.currentLine=1245214;
 //BA.debugLineNum = 1245214;BA.debugLine="Label1.TextColor = Colors.Black";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1245215;
 //BA.debugLineNum = 1245215;BA.debugLine="Dim tf As Typeface = Typeface.LoadFromAssets(\"jo";
_tf = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
_tf.setObject((android.graphics.Typeface)(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets("josefinsans-bold.ttf")));
RDebugUtils.currentLine=1245216;
 //BA.debugLineNum = 1245216;BA.debugLine="Label3.Typeface = tf.DEFAULT_BOLD";
mostCurrent._label3.setTypeface(_tf.DEFAULT_BOLD);
RDebugUtils.currentLine=1245218;
 //BA.debugLineNum = 1245218;BA.debugLine="Label1.Width = -2 '100%x - Label1.Left - 10dip";
mostCurrent._label1.setWidth((int) (-2));
RDebugUtils.currentLine=1245219;
 //BA.debugLineNum = 1245219;BA.debugLine="Label2.Width = 100dip";
mostCurrent._label2.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=1245220;
 //BA.debugLineNum = 1245220;BA.debugLine="Label2.SetLayout(100%x - Label2.Width - 10dip, 5";
mostCurrent._label2.SetLayout((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._label2.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),(int) (-2));
RDebugUtils.currentLine=1245221;
 //BA.debugLineNum = 1245221;BA.debugLine="Label3.Width = 100%x - Label1.Left - 10dip";
mostCurrent._label3.setWidth((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._label1.getLeft()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=1245222;
 //BA.debugLineNum = 1245222;BA.debugLine="tf = Typeface.LoadFromAssets(\"josefinsans-semibo";
_tf.setObject((android.graphics.Typeface)(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets("josefinsans-semibolditalic.ttf")));
RDebugUtils.currentLine=1245223;
 //BA.debugLineNum = 1245223;BA.debugLine="Label3.Typeface = tf";
mostCurrent._label3.setTypeface((android.graphics.Typeface)(_tf.getObject()));
RDebugUtils.currentLine=1245225;
 //BA.debugLineNum = 1245225;BA.debugLine="Dim cd As GradientDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=1245226;
 //BA.debugLineNum = 1245226;BA.debugLine="cd.Initialize(\"TOP_BOTTOM\", Array As Int(Colors.";
_cd.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.DarkGray,anywheresoftware.b4a.keywords.Common.Colors.White});
RDebugUtils.currentLine=1245227;
 //BA.debugLineNum = 1245227;BA.debugLine="cd.CornerRadius = 20dip";
_cd.setCornerRadius((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))));
RDebugUtils.currentLine=1245228;
 //BA.debugLineNum = 1245228;BA.debugLine="Label2.Background = cd";
mostCurrent._label2.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=1245229;
 //BA.debugLineNum = 1245229;BA.debugLine="Label2.Gravity = Gravity.CENTER";
mostCurrent._label2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 };
RDebugUtils.currentLine=1245231;
 //BA.debugLineNum = 1245231;BA.debugLine="End Sub";
return "";
}
public static String  _lv_onitemclick(com.salvadorjhai.data.JSViewHolder _view,int _position) throws Exception{
RDebugUtils.currentModule="jsonactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lv_onitemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "lv_onitemclick", new Object[] {_view,_position});
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub LV_OnItemClick(view As JSViewHolder, position";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="ToastMessageShow($\"Position ${position}\"$, False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(("Position "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_position))+"")),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="End Sub";
return "";
}
public static String  _mnuadd_click() throws Exception{
RDebugUtils.currentModule="jsonactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mnuadd_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mnuadd_click", null);
anywheresoftware.b4a.objects.collections.Map _m = null;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub mnuAdd_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="m.Initialize";
_m.Initialize();
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="m.Put(\"app_name\", DateTime.Now)";
_m.Put((Object)("app_name"),(Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="m.Put(\"app_version\", \"test\")";
_m.Put((Object)("app_version"),(Object)("test"));
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="m.Put(\"catch_phrase\", \"12345789\")";
_m.Put((Object)("catch_phrase"),(Object)("12345789"));
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="Adapter.ItemAdd(m)";
mostCurrent._adapter.ItemAdd((Object)(_m.getObject()));
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="LV.Selection = Adapter.Count";
mostCurrent._lv.setSelection(mostCurrent._adapter.getCount());
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="End Sub";
return "";
}
}