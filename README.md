
# 工具类 Android Java Kotlin 各种工具 -张三疯 
# [1.万能AlertDialog 建造者模式+kotlin](#link1)
# [2.万能Popwindow 建造者模式+kotlin](#link2)
# [3.Logger 格式化日志](#link3)




[![](https://jitpack.io/v/zxyUncle/tools.svg)](https://jitpack.io/#zxyUncle/tools)

Gradle
-----
Step 1
	 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

        implementation 'com.github.zxyUncle:tools:Tag'

Maven
-----
Step 1

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.zxyUncle</groupId>
	    <artifactId>tools</artifactId>
	    <version>Tag</version>
	</dependency>

 
 
### link1
-----------
## 万能AlertDialog 建造者模式+kotlin 
   
样式1-自带Dialog
---

 - 简单版

        alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .showStyle1()                   //显示样式1 0xD81B60
                .create(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm1 -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel1 -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()
                    }
                })

[![](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/dialog1.jpg)](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/dialog1.jpg)



 - 完整版

        alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .showStyle1()                   //必选  显示样式1
                .setTransparency(0.4f)          //可选  设置窗口透明度，默认0.5
                .setTitle("我是元婴期")          //可选  设置标题
                .setConfirm("左手大保健")        //可选  确定按钮文案
                .setCancel("右手打和尚")         //可选  取消按钮文案
                .setTitleColor(resources.getColor(R.color.colorAccent,null))//或者 0xD81B60  //可选  设置标题颜色
                .setConfirmColor(resources.getColor(R.color.colorAccent,null))//或者 0xD81B60//可选  确定按钮颜色
                .setCancelColor(resources.getColor(R.color.colorAccent,null)) //或者 0xD81B60 //可选  取消按钮颜色
                .create(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm1 -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel1 -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()   //取消Dialog
                    }
                })
        //可选  设置按钮的字体大小，文字样式等等
        //val layoutView = alertDialogUtils.layoutView
        //layoutView.findViewById<TextView>(R.id.dialog_msg_title1).textSize=16f
        //layoutView.findViewById<TextView>(R.id.dialog_msg_cancel1).textSize=16f
        //layoutView.findViewById<TextView>(R.id.dialog_msg_confirm1).textSize=16f
        
[![](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/dialog1.1.jpg)](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/dialog1.1.jpg)

样式2-自带Dialog
------------
 - 简单版

            alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .showStyle2()                   //必选    显示样式2
                .create(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm2 -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel2 -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()
                    }
                })

[![](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/dialog2.jpg)](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/dialog2.jpg)         
 - 完整版   

        alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .showStyle2()                   //必选    显示样式2
                .setTransparency(0.4f)          //可选    设置窗口透明度，默认0.5
                .setTitle("张三疯标题")          //可选    设置标题
                .setConfirm("你好")              //可选    确定按钮文案
                .setCancel("我不好")             //可选    取消按钮文案
                .setTitleColor(resources.getColor(R.color.colorPrimaryDark,null)) //或 0xD81B60//可选设置标题颜色
                .setConfirmColor(resources.getColor(R.color.colorPrimaryDark,null)) //或 0xD81B60//可选确定颜色
                .setCancelColor(resources.getColor(R.color.colorPrimaryDark,null)) //或 0xD81B60//可选取消按钮颜色
                .create(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm2 -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel2 -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()
                    }
                })
        //可选  设置按钮的字体大小，文字样式等等
//        val layoutView = alertDialogUtils.layoutView
//        layoutView.findViewById<TextView>(R.id.dialog_msg_title1).textSize=16f
//        layoutView.findViewById<TextView>(R.id.dialog_msg_cancel1).textSize=16f
//        layoutView.findViewById<TextView>(R.id.dialog_msg_confirm1).textSize=16f
 

[![](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/dialog2.1.jpg)](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/dialog2.1.jpg) 

## 样式三-自定义Dialog ##

            alertDialogUtils = AlertDialogUtils.build(this)
            .setView(R.layout.dialog_button)    //必选 设置布局View
            .setCancelable(true)                //可选 设置是否可以取消，默认true
            .setTransparency(0f)                //可选 设置窗口透明度，默认0.5
            .setOnClick(R.id.but1, R.id.but2, R.id.but3)    //可选 设置布局的点击事件
            .create(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                override fun onClickDialog(view: View) {
                    when (view.id) {
                        R.id.but1 -> {
                            Toast.makeText(this@MainActivity, "but1", Toast.LENGTH_SHORT).show()
                        }
                        R.id.but2 -> {
                            Toast.makeText(this@MainActivity, "but2", Toast.LENGTH_SHORT).show()
                        }
                        R.id.but3 -> {
                            Toast.makeText(this@MainActivity, "but3", Toast.LENGTH_SHORT).show()
                        }
                    }
                    alertDialogUtils.cancel()   //取消Dialog
                }
            })
            
[![](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/dialog3.jpg)](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/dialog3.jpg)    

### link2
-----------
## 2.万能Popwindow 建造者模式+kotlin
       
       
### link3
-----------
## 3.Logger 格式化日志 --转载[Logger][1]
  [1]: https://github.com/orhanobut/logger

###使用：

 1. 初始化：什么时候都行，最好在Application中初始化（可以多次初始化）
    包名：com.zxy.zxytools.logger.LoggerUtils
    **LoggerUtils.init("msg")** //msg是默认的日志过滤TAG     
 2. 使用：  
        包名：com.orhanobut.logger.Logger
        **Logger.d("debug")**  
        **Logger.e("error")   
        Logger.w("warning")    
        Logger.v("verbose")    
        Logger.i("information");    
        Logger.t("121").i("information");   //使用临时的日志过滤TAG，也可以使用默认的msg TAG     
        特殊的：   
        Logger.xml(）//输出xml，可以使activlti_main.xml或者androidmanifast.xml等    
        Logger.json("字符串json")                   //输出json     
        Logger.json(new Gson().toJson(UserBean))    //输出json**    

        例：        Logger.json("{\n" +
                "    \"code\": \"00\",\n" +
                "    \"msg\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"uid\": \"201874\",\n" +
                "        \"type\": \"F\",\n" +
                "        \"channel\": \"\",\n" +
                "        \"userName\": \"18501617787\",\n" +
                "        \"avatar\": \"U/20181128/038e56ebc74448f0ba7333999cd57857\",\n" +
                "        \"accessToken\": \"A1E2LzxhUGFZvZyFAwzs70G6lx40cUBmVQIqhFiEYX/b4mQ=\",\n" +
                "        \"tokenType\": \"Bearer\",\n" +
                "        \"expires\": 604800,\n" +
                "        \"refreshToken\": \"439cd7cb2a69a011\",\n" +
                "        \"timestamp\": 1568890345144,\n" +
                "        \"inviteCode\": \"3640\",\n" +
                "        \"isExist\": 0\n" +
                "    }\n" +
                "}")`
 3. 效果图
[![](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/logger1.png)](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/logger1.png)     
[![](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/logger2.png)](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/logger2.png)      

 4. 设置各个日志级别的颜色
    我的配置颜色：     
    **Assert --- E170D6    
    Debug --- 0091E1     
    Error ---FF5F5F       
    Info --- 56E13E    
    Verbose --- E1E1E1      
    Warning --- E1E125**    
  
[![](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/logger3.png)](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/logger3.png)    

[![](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/logger4.png)](https://raw.githubusercontent.com/zxyUncle/tools/master/picature/logger4.png) 


##更新：

 1.6. 日志工具    
 
 
 
######持续更新---------
