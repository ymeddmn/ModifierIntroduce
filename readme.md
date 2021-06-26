关注公众号学习更多知识

![](https://files.mdnice.com/user/15648/404c2ab2-9a89-40cf-ba1c-02df017a4ae8.jpg)
**本文会对Modifier修饰符进行详尽的解说，报你收货满满**

## Modifier

Modifier 可以被翻译为修饰符，可以用来修饰以下内容：

- 更改可组合项的大小、布局、行为和外观

- 添加信息，如无障碍标签

- 处理用户输入

- 添加高级互动，如使元素可点击、可滚动、可拖动或可缩放

## item 代码案例

第三节属性扩展中的案例都是基于本节中 item 方法的形参进行赋值得到的

### item1

1. item1 代码

```
@Composable
fun item1(m: Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = m
                .size(100.dp)
                .background(color = Color.Red),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "安安安安卓",
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.White)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}
```

2. item 默认的展示效果如下：

![](https://files.mdnice.com/user/15648/547ae1f1-7e96-4b9c-831e-a288e1a3a26d.png)

## Modifier 所有扩展方法详解

### selectable（compose 实现单选）

这里起初我是没头绪的，就拼了命的百度找资料的，但是说实话一篇讲这里的文章都没有。所以只能去官网翻译官方文档了。基本上花了半小时才搞明白啥意思。眼睛又废了，本周计划的 Livedata 源码也讲不了了

总的来说 selectable 就是用来实现单选的，可作为 RadioGroup 使用，也可作为 TabView 使用。

1. 代码

```
val icons = listOf<Triple<Int, Int, String>>(
        Triple(R.drawable.apple, R.drawable.lufeicry, "海贼王"),
        Triple(R.drawable.nameismile, R.drawable.nameicry, "娜美"),
        Triple(R.drawable.luobinsmile, R.drawable.luobincry, "罗宾")
    )
    var selectedItem = remember {
        mutableStateOf(icons[0])
    }
    Column(
        modifier = Modifier.fillMaxSize(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = "公众号：\"安安安安卓\"，选择:",
                style = TextStyle(
                    color = Color.Black, fontSize = 15.sp
                ),
                modifier = Modifier.weight(0.7f)
            )
            Text(
                text = selectedItem.value.third,
                style = TextStyle(color = Color.Red, fontSize = 25.sp),
                modifier = Modifier.weight(0.3f)
            )
        }
        Row(
//            modifier = Modifier
//                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            icons.forEach {
                val selected = selectedItem.value == it
                Image(
                    painter = painterResource(id = if (selected) it.first else it.second),
                    contentDescription = null,
                    modifier = Modifier
                        .selectable(
                            selected = selected,
                            enabled = true,
                            role = null,
                            onClick = {
                                selectedItem.value = it
                            })
                        .size(100.dp)
                )
            }
        }
    }
```

2. 效果
   ![](https://files.mdnice.com/user/15648/cbd92c5e-8fed-4f43-b68a-13d1abf2bc76.gif)

### fillMaxSize

1. 代码

```
item1(m = Modifier.background(color = Color.Blue).fillMaxSize(0.75f))
```

2. 效果

设置属性后填充了父容器 0.75 倍的大小

![](https://files.mdnice.com/user/15648/4b6d2013-7c4d-46ec-ad58-1a02e388e186.png)

### height

1. 代码

```
 item1(m = Modifier.background(color = Color.Blue).height(30.dp))
```

2. 效果

设置高度为 30 后，宽度也跟随进行了改变
![](https://files.mdnice.com/user/15648/58238b6c-7df8-48d2-beeb-bfabdece8096.png)

### width

同 height

### size

1. 代码

   item1(m = Modifier.background(color = Color.Blue).size(30.dp))

2. 效果图

宽高都变为了 30dp

![](https://files.mdnice.com/user/15648/9f722ee8-35f0-41ac-9637-6fbf6de476d6.png)

### background

#### 简单使用 background 设置背景色

item1(m = Modifier.background(color = Color.Red))

#### 实现圆形背景

1. 代码

```
item1(m = Modifier.background(color = Color.Red,shape = CircleShape))
```

2. 效果

![](https://files.mdnice.com/user/15648/c1d032e2-4c14-477f-8b36-cfb5b4c09210.png)

#### 实现圆角背景

1. 代码

```
item1(m = Modifier.background(color = Color.Red,shape = RoundedCornerShape(10.dp)))
```

2.效果

![](https://files.mdnice.com/user/15648/84fe2759-502d-4365-a97f-baacbc5011ab.png)

#### 实现渐变效果

1. 代码

```
 item1(m = Modifier.background(brush = Brush.linearGradient(mutableListOf(Color.Red,Color.Green,Color.Yellow,Color.Gray))))

```

2. 效果

![](https://files.mdnice.com/user/15648/4e09a793-9e9d-48f1-a50d-2294e574df5e.png)
默认的线性渐变效果是从左上到右下的

### verticalScroll

加上它 Column 就可以垂直方向进行滚动了

1. 代码

```
 Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(1f)
    )
```

### padding、border

1. 代码

```
 item1(
            m = Modifier
                .background(color = Color.Red,shape = CircleShape)
                .padding(4.dp)
                .border(border = BorderStroke(2.dp, color = Color.Green),shape = CircleShape)
        )
```

2. 效果

   本例实现了这样一个效果，先添加圆形背景，再添加 padding，最后添加圆形 border

![](https://files.mdnice.com/user/15648/038344c4-f8fb-4983-807f-45f091d55e4b.png)

### clip

注意 background 方法和 clip 方法不能同时使用，否则 background 会覆盖 clip 的效果

1. 代码

```
 Box(modifier = Modifier.clip(CircleShape)) {
            Box(Modifier.size(200.dp).background(color = Color.Green))
        }
```

2. 效果

![](https://files.mdnice.com/user/15648/0c5ef419-05bf-42c3-9d7d-8c420c5b6c39.png)

### clipToBounds

暂无

### offset

根据文档中的描述，offset 可以对控件内部元素的内容进行偏移，比如：

如果内部元素是 LTR，则 x 正值向右，负值向左

如果内部元素是 RTL，则 x 正值向左，负值向右

1. 代码

```
 item1(m = Modifier.background(color = Color.Red).offset(x=30.dp))
```

2. 效果

![](https://files.mdnice.com/user/15648/ec9d7bc4-88f0-4dfe-b462-18149c2201ef.png)

### absoluteOffset

与 offset 类似，不过不会考虑布局方向。

正值向右或下，负值向左或上

### absolutePadding

暂无

### alpha

设置透明度

1. 代码

```
item1(m = Modifier.background(color = Color.Red).alpha(0.3f))
```

2. 效果

![](https://files.mdnice.com/user/15648/f4ccd598-1722-4f8e-8de6-be982f5303f1.png)

### clickable

让任意控件变的可点击，并且会附加水波纹效果

1. 代码

   item1(m = Modifier.background(color = Color.Red).clickable(onClick = {
   Log.e("tag","安安安安卓")
   }))

2. 效果

   打印日志


```
E/tag: 安安安安卓
E/tag: 安安安安卓
E/tag: 安安安安卓
E/tag: 安安安安卓
```


### defaultMinSize

可以设置控件的最小尺寸

1. 代码

```
item1(m = Modifier.background(color = Color.Red).defaultMinSize(300.dp))
```

2. 效果

![](https://files.mdnice.com/user/15648/6adf23f1-1115-4a09-8b44-15fa1c1942e8.png)
item1 中控件的宽度是 100dp，我们将最小控件尺寸设置为 300dp，然后控件宽度自动的变为了 300dp，说明最小尺寸生效了。

### draggable

暂无

### drawBehind

暂无

### drawWithCache

暂无

### drawWithContent

暂无

### heightIn

设置最小高度

### horizontalScroll

使我们的空间可以水平滑动，我们代码中用的 Text 做 demo，结果 Text 变成了单行可滑动

1. 代码

```
 Text(
            text = "公众号，安安安安卓，是一个用来分享安卓知识的公众号，ad发法撒扥a懂法A栋发扥as扥",
            modifier = Modifier
                .horizontalScroll(enabled = true, state = ScrollState(12))
                .height(100.dp)
                .background(color = Color.Green),
            textAlign = TextAlign.Center
        )
```

2. 效果
   ![](https://files.mdnice.com/user/15648/cd3ef600-6e61-410c-896b-69da7aba528a.gif)

### indication

暂无

### layout

暂无

### layoutId

给控件设置 id

使用ConstraintLayout的时候会有用

1. 代码

```
item1(m = Modifier.background(color = Color.Red).layoutId("name"))
```

### nestedScroll

暂无

### onFocusChanged

暂无

### onFocusEvent

暂无

### onGlobalPositioned

暂无

### onKeyEvent

暂无

### onPreviewKeyEvent

暂无

### onSizeChanged

暂无

### paddingFrom

暂无

### PaddingFromBaseLine

暂无

### paint

暂无

### pointInput

暂无

### requireHeight

1. 代码

2. 效果

### requireHeightIn

重新设置最小高度，

1. 代码

```
item1(m = Modifier.background(color = Color.Red).requiredHeight(height = 20.dp))
```

2. 效果

![](https://files.mdnice.com/user/15648/9b695bf1-908d-4a06-a7d8-d1a678474d9d.png)
蓝框中的高度是调用了 requireHeightIn 方法的效果

框外的是正常的控件高度

### requireSize

同：requireHeightIn

### requireWidth

同：requireHeightIn

### requireWidthIn

同：requireHeightIn

### scale

对控件里面的内容进行缩放

1. 代码

```
item1(m = Modifier.background(color = Color.Red).scale(2f))
```

2. 效果

![](https://files.mdnice.com/user/15648/b3c29490-bc3f-422b-aa7a-a2364805207a.png)

### shadow
阴影效果
1. 代码

```
  item1(
            m = Modifier
                .background(color = Color.Red)
                .shadow(elevation = 3.dp, shape = RectangleShape,clip = true)//不知道是否是我用的不对，效果非常不好看
        )
```

2. 效果

感觉效果好丑，肯定是我用错了
![](https://files.mdnice.com/user/15648/28372c79-aacb-4693-892c-d22875a5473f.png)


### sizeIn

最小尺寸

### swipeable

暂无

### toggleable
非常适合用来做开关效果，本例我们用自己找到的两张图模拟点击切换状态
1. 代码

```
 val selected = remember {
        mutableStateOf(true)
    }
    Image(
        painter = painterResource(id = if (selected.value) R.drawable.apple else R.drawable.luobinsmile),
        contentDescription = null,
        modifier = Modifier
            .toggleable(
                value = selected.value,
                enabled = true,
                role = null,
                onValueChange = {
                    selected.value = it
                })
            .size(100.dp)
    )
```

2. 效果

![](https://files.mdnice.com/user/15648/adda8430-9486-4fdb-8a95-3764b221b5ad.gif)

### transformable

暂无

### withIn

可以设置最小尺寸和最大尺寸

1. 代码

item1(m = Modifier.background(color = Color.Red).widthIn(min = 50.dp,max = 200.dp))

### wrapContentHeight

暂无

### wrapContentWidth

暂无

### wrapContentSize

暂无

### zIndex

zIndex 用来设置控件的层级，zIndex 值较大的会覆盖在 zIndex 值较小的控件上方。如果两个控件 zIndex 一样大，那么会按照他们的代码中的顺序摆放

1. 代码

   本例代码，我们创建了两个 Text，

第一个红色 zIndex=5

第二个绿色 zIndex=4

按我们的预期红色的会处于绿色的控件的顶部

```
 Box {

            Text(
                text = "安安安安卓2",
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Red)
                    .zIndex(5f)
            )
            Text(
                text = "安安安安卓1",
                modifier = Modifier
                    .size(150.dp)
                    .background(color = Color.Green)
                    .zIndex(4f)
            )

        }
```

2. 效果

![](https://files.mdnice.com/user/15648/d2e7aeec-f1a2-4c4a-b85d-c2d90dcfe6f0.png)

最终效果与我们预期的一致

> 关注我的公众号 **“安安安安卓”** 学习更多知识
