# Android Java Kotlin 各种工具 -张三疯

 1. 万能AlertDialog 建造者模式+kotlin
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

     alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .setTransparency(0.4f)
                .showStyle1(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()
                    }
                })

样式2-自带Dialog
------------
alertDialogUtils =
            AlertDialogUtils
                .build(this)
                .setTransparency(0.8f)
                .showStyle2(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
                    override fun onClickDialog(view: View) {
                        when (view.id) {
                            R.id.dialog_msg_confirm -> {
                                Toast.makeText(this@MainActivity, "确定", Toast.LENGTH_SHORT).show()
                            }
                            R.id.dialog_msg_cancel -> {
                                Toast.makeText(this@MainActivity, "取消", Toast.LENGTH_SHORT).show()
                            }
                        }
                        alertDialogUtils.cancel()
                    }
                })
                
## 样式三-自定义Dialog ##

    alertDialogUtils = AlertDialogUtils.build(this)
            .setView(R.layout.dialog_button)    //设置布局View
            .setCancelable(true)                //设置是否可以取消，默认true
            .setTransparency(0f)                //设置窗口透明度，默认0.5
            .setOnClick(R.id.but1, R.id.but2, R.id.but3)    //设置布局的点击事件
            .show(object : AlertDialogUtils.Builder.AlertDialogUtilsListener {
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
