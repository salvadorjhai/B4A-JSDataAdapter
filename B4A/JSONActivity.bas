Type=Activity
Version=7
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private Label1 As Label
	Private Label3 As Label
	Private Label2 As Label
	Private ImageView1 As ImageView
	
	Dim LV As JSListView2	
	Dim Adapter As JSListAdapter
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.Title = "JSListAdapter (ListAdapter)"
	Activity.AddMenuItem("Add", "mnuAdd")
	
	'Load JSON file - will just use this to load up our list
	'This json file contains list of records
	Dim js As JSONParser
	js.Initialize(File.ReadString(File.DirAssets, "MOCK_DATA.json"))
	
	'load up data (list)
	Dim data As List =  js.NextArray
	
	'Initialize JSListAdapter and set data (list)
	Adapter.Initialize("Adapter", data)
	
	'Initialize JSListView2 and set the adapter
	LV.Initialize("LV")
	Activity.AddView(LV, 0dip, 0dip, 100%x, 100%y)
	LV.Adapter = Adapter
	
	' optional
	LV.CacheColorHint = 0
	LV.DividerHeight = 5dip
	LV.FastScrollEnabled = True

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub mnuAdd_Click
	Dim m As Map 
	m.Initialize
	m.Put("app_name", DateTime.Now)
	m.Put("app_version", "test")
	m.Put("catch_phrase", "12345789")	
	Adapter.ItemAdd(m)
	LV.Selection = Adapter.Count
	'LV.smoothScrollToPosition(Adapter.Count)
End Sub

Sub Adapter_onGetView(position As Int, viewHolder As JSViewHolder)
	'check if container was set
	If viewHolder.Container = Null Then
		'load new layout
		Dim p As Panel
		p.Initialize("")
		p.LoadLayout("Layout1")
		
'		Dim cd2 As GradientDrawable
'		cd2.Initialize("TOP_BOTTOM", Array As Int(Colors.White, Colors.White))
'		cd2.CornerRadius = 0dip		
'		
'		Dim cd3 As GradientDrawable
'		cd3.Initialize("TR_BL", Array As Int(Colors.LightGray, Colors.White))
'		cd3.CornerRadius = 0dip
		
'		Dim stl As StateListDrawable
'		stl.Initialize 
'		stl.AddState(stl.State_Pressed, cd3)
'		stl.AddCatchAllState(cd2)
'		p.Background = stl
		
		'set view id
		viewHolder.Initialize(p, 100dip, 100%x)
		viewHolder.setViewId(Label1, 10)
		viewHolder.setViewId(Label2, 20)
		viewHolder.setViewId(Label3, 30)
		viewHolder.setViewId(ImageView1, 40)
		
		'customize view (width/height)
		Label1.TextColor = Colors.White
		Dim tf As Typeface = Typeface.LoadFromAssets("josefinsans-bold.ttf")
		Label3.Typeface = tf.DEFAULT_BOLD

		Label1.Width = -2 '100%x - Label1.Left - 10dip
		Label2.Width = 100dip
		Label2.SetLayout(100%x - Label2.Width - 10dip, 5dip, 100dip, -2)
		Label3.Width = 100%x - Label1.Left - 10dip
		tf = Typeface.LoadFromAssets("josefinsans-semibolditalic.ttf")
		Label3.Typeface = tf		
		'
'		Dim cd As GradientDrawable
'		cd.Initialize("TOP_BOTTOM", Array As Int(Colors.DarkGray, Colors.White))
'		cd.CornerRadius = 20dip
'		Label2.Background = cd
		Label2.Gravity = Gravity.CENTER
	End If
End Sub

Sub Adapter_onBindView(position As Int, viewHolder As JSViewHolder)
	'findview by id
	Label1 = viewHolder.findViewById(10)
	Label2 = viewHolder.findViewById(20)
	Label3 = viewHolder.findViewById(30)
	ImageView1 = viewHolder.findViewById(40)
	
	'get data to map
	Dim m As Map = Adapter.DataSource.Get(position)
	
	'display map values
	Label1.Text = (position+1) & ". " & m.Get("app_name")
	Label2.Text = m.GetDefault("app_version", "")
	Label3.Text = m.GetDefault("catch_phrase", "")
End Sub

Sub LV_OnItemClick(view As JSViewHolder, position As Int)
	ToastMessageShow($"Position ${position}"$, False)
End Sub