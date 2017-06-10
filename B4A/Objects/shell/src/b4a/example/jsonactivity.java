
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

public class jsonactivity implements IRemote{
	public static jsonactivity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public jsonactivity() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("jsonactivity"), "b4a.example.jsonactivity");
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
		pcBA = new PCBA(this, jsonactivity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _imageview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _lv = RemoteObject.declareNull("com.salvadorjhai.widgets.JSListView2");
public static RemoteObject _adapter = RemoteObject.declareNull("com.salvadorjhai.data.JSListAdapter");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.sqlactivity _sqlactivity = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",jsonactivity.mostCurrent._activity,"Adapter",jsonactivity.mostCurrent._adapter,"ImageView1",jsonactivity.mostCurrent._imageview1,"Label1",jsonactivity.mostCurrent._label1,"Label2",jsonactivity.mostCurrent._label2,"Label3",jsonactivity.mostCurrent._label3,"LV",jsonactivity.mostCurrent._lv,"Main",Debug.moduleToString(b4a.example.main.class),"SQLActivity",Debug.moduleToString(b4a.example.sqlactivity.class),"Starter",Debug.moduleToString(b4a.example.starter.class)};
}
}