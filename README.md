# boost_core_demo
结合 flutterBoost 将flutter嵌入到 安卓项目 

请clone工程之后，注意一下几点：
1. flutter项目的 `flutterSDK`版本我用的是 `2.5.3`
2. 作为flutter开发者的角色，要测试 发布flutter产物到native工程的话，执行 `flutter:flutter_publish` 任务即可，但是你们去执行可能会失败，因为我写死了 flutter产物仓库（gitRepoUrl）的地址为我的内部私库，建议在 `flutter_config.gradle` 文件中将 `gitRepoUrl` 仓库地址改成 你们能够SSH访问的git仓库地址 ，`repoName` 改为 你们自己的仓库名，`proName` 随意，符合你们的业务需求即可
3. 作为普通开发者的角色，要测试 无感打混合了Flutter的apk，请执行任务：`assembleDebug` ， 或者 `assembleRelease` ，只要是带 assemble的任务都可以
4. 我在写这个Demo的时候使用的并不是最新版的AndroidStudio，目前最新的as创建出的android新项目的gradle结构不同，flutterBoost并没有对这种项目结构提供可行的集成方案，所以集成会很麻烦
5. 这只是我提供的 不依赖Flutter环境，也能集成Flutter模块的一种简单思路，各位大佬可以根据业务需求去细化精炼没一个步骤
