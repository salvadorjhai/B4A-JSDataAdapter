# B4A-JSDataAdapter
Adapter Wrapper for B4A (Basic4Android)
Supports List and Cursor Adapter to be use in [JSListView](https://github.com/salvadorjhai/B4A-JSListView)

### Sample
##### Using List Adapter 
```
'sample list from json file
Dim json As JSONParser
json.Initialize(File.ReadString(File.DirAssets, "drug_list.json"))
Dim dataSource As List = json.NextArray

'initialize adapter
adapter.Initialize("adapter", dataSource)

'set it on JSListView
listview.Adapter = adapter
```
##### Using Cursor Adapter
```
'sample sqlite connection	
cn.Initialize(File.DirInternal, "1.db", False)	
Dim cur As Cursor = cn.ExecQuery("SELECT * FROM MOCK_DATA")

'Initialize JSCursorAdapter and set cursor
Adapter.Initialize("adapter", cur)
listview.Adapter = adapter
```


### Important events
`_onGetView(position As Int, viewHolder As JSViewHolder)` - this is the event where you will initialize your item layout, you will need to check if the container is null.

```
Sub adapter_onGetView(position As Int, viewHolder As JSViewHolder)
    'we will load new layout if container is null
    If viewHolder.Container	= Null Then
        'load layout container (item layout)
        Dim p As Panel
        p.Initialize("")
        p.LoadLayout("layout")
        viewHolder.Initialize(p, 110dip, 100%x)

        'set layout
        lblDrugname.Width = 100%x - lblDrugname.Left - 10dip
        lblDrugname.Gravity = Bit.Or(Gravity.LEFT, Gravity.CENTER_HORIZONTAL)
        lblQuantity.Gravity = Gravity.CENTER

        'set view id
        viewHolder.setViewId(imgAvatar, 10)
        viewHolder.setViewId(lblDrugname, 20)
        viewHolder.setViewId(lblQuantity, 30)
        viewHolder.setViewId(btnAdd, 40)
        viewHolder.setViewId(btnMinus, 50)		
    End If
End Sub
```

`_onBindView(position As Int, viewHolder As JSViewHolder)` - this is the event where you will set/bind your data to your views

```
Sub adapter_onBindView(position As Int, viewHolder As JSViewHolder)
    If viewHolder.Container = Null Then Return

    'find view
    imgAvatar = viewHolder.findViewById(10)
    lblDrugname = viewHolder.findViewById(20)
    lblQuantity = viewHolder.findViewById(30)
    btnAdd = viewHolder.findViewById(40)
    btnMinus = viewHolder.findViewById(50)

    'bind data to view
    Dim mapData As Map = adapter.DataSource.Get(position)
    lblDrugname.Text = mapData.Get("drug_name")
    lblQuantity.Text = mapData.Get("quantity")
    'set position info on your view
    btnAdd.Tag = position
    btnMinus.Tag = position
    lblDrugname.Tag = position
End Sub
```
