# Android Java Kotlin 各种工具 -张三疯

# [1.万能AlertDialog 建造者模式+kotlin](#link1)
# [2.万能Popwindow 建造者模式+kotlin](#link2)

#link1
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

        implementation 'com.github.zxyUncle:tools:1.0'

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
            

#link2
