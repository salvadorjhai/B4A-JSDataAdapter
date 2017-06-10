
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class sqlactivity implements IRemote{
	public static sqlactivity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public sqlactivity() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("sqlactivity"), "b4a.example.sqlactivity");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, sqlactivity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _cn = RemoteObject.declareNull("com.salvadorjhai.JSSQLiteDatabase");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _imageview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _lv = RemoteObject.declareNull("com.salvadorjhai.widgets.JSListView2");
public static RemoteObject _pos = RemoteObject.createImmutable(0);
public static RemoteObject _adapter = RemoteObject.declareNull("com.salvadorjhai.data.JSCursorAdapter");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.jsonactivity _jsonactivity = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",sqlactivity.mostCurrent._activity,"Adapter",sqlactivity.mostCurrent._adapter,"cn",sqlactivity._cn,"ImageView1",sqlactivity.mostCurrent._imageview1,"JSONActivity",Debug.moduleToString(b4a.example.jsonactivity.class),"Label1",sqlactivity.mostCurrent._label1,"Label2",sqlactivity.mostCurrent._label2,"Label3",sqlactivity.mostCurrent._label3,"LV",sqlactivity.mostCurrent._lv,"Main",Debug.moduleToString(b4a.example.main.class),"pos",sqlactivity._pos,"Starter",Debug.moduleToString(b4a.example.starter.class)};
}
}