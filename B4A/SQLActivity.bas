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
	Dim cn As SQL
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private Label1 As Label
	Private Label3 As Label
	Private Label2 As Label
	Private ImageView1 As ImageView
	
	Dim LV As JSListView2
	Dim pos As Int = 0
	Dim Adapter As JSCursorAdapter
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.Title = "JSCursorAdapter (Cursor)"
	Activity.AddMenuItem("Add", "mnuAdd")

	If File.Exists(File.DirInternal, "1.db") = False Then
		File.Copy(File.DirAssets, "1.db", File.DirInternal, "1.db")
	End If
	
	'sample sql connection	
	cn.Initialize(File.DirInternal, "1.db", False)	
	Dim cur As Cursor = cn.ExecQuery("SELECT * FROM MOCK_DATA")
	
	'Initialize JSCursorAdapter and set cursor
	Adapter.Initialize("Adapter", cur)
	
	'Initialize JSListView2 and set the adapter
	LV.Initialize("LV")
	Activity.AddView(LV, 0dip, 0dip, 100%x, 100%y)
	LV.Adapter = Adapter
	
	' optional 
	LV.CacheColorHint = 0
	LV.DividerHeight = 1
	LV.FastScrollEnabled = True
End Sub

Sub Activity_Resume
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	If UserClosed Then cn.Close
End Sub


Sub mnuAdd_Click
	Dim m As ContentValues
	m.Initialize
	m.PutString("app_name", DateTime.Now)
	m.PutString("app_version", "test")
	m.PutString("catch_phrase", "12345789")
	cn.ExecInsert("MOCK_DATA", "", m)
	'* requier
	Dim cur As Cursor = cn.ExecQuery("SELECT * FROM MOCK_DATA")	
	Adapter.Initialize("Adapter", cur)	
	LV.Adapter = Adapter
	LV.Selection = Adapter.Count
End Sub

Sub Adapter_onGetView(Position As Int, viewHolder As JSViewHolder)
	'check if container was set
	If viewHolder.Container = Null Then
		'load new layout
		Dim p As Panel
		p.Initialize("")
		p.LoadLayout("Layout1")
		
		'set view id
		viewHolder.Initialize(p, 100dip, 100%x)
		viewHolder.setViewId(Label1, 10)
		viewHolder.setViewId(Label2, 20)
		viewHolder.setViewId(Label3, 30)
		viewHolder.setViewId(ImageView1, 40)
		
		'customize view (width/height)
		Label1.Width = 100%x
		Label2.Width = 100%x
		Label3.Width = 100%x
	End If
	pos=Position
End Sub

Sub Adapter_onBindView(Position As Int, viewHolder As JSViewHolder)
	'findview by id	
	Label1 = viewHolder.findViewById(10)
	Label2 = viewHolder.findViewById(20)
	Label3 = viewHolder.findViewById(30)
	ImageView1 = viewHolder.findViewById(40)
	
	'set cursor position
	Dim m As Cursor = Adapter.DataSource
	m.Position = Position
	
	'display cursor values
	Label1.Text = (Position+1) & ". " & m.GetString("app_name")
	Label2.Text = m.GetString("app_version")
	Label3.Text = m.GetString("catch_phrase")
	
	'you can still customize your views
	Label1.TextColor = Colors.Red
	If Label2.Text= "10" Then
		Label1.TextColor = Colors.Blue 		
	End If
	
End Sub

Sub LV_OnItemLongClick(view As JSViewHolder, position As Int)
	If position < 0 Then Return 
	
	Dim cur As Cursor = Adapter.DataSource
	cur.Position = position
	Dim m As ContentValues = cn.CursorRowToContentValues(cur)	
	
	m.Remove("id")
	m.PutString("app_name", "Updated: " & DateTime.Now)
	m.PutString("app_version", "10")
	m.PutString("catch_phrase", "12345789")
	cn.ExecUpdate("MOCK_DATA", m, "rowid = ?", Array As String(position+1))
	
	'* requier
	Dim cur As Cursor = cn.ExecQuery("SELECT * FROM MOCK_DATA")
	Adapter.Initialize("Adapter", cur)
	LV.Adapter = Adapter
	LV.Selection = position
		
End Sub