# java-utils
Java工具类

## 使用方式
### 采用Maven构建项目
在pom中引入依赖，版本换成对应版本即可,最新版本详见Releases
```
<dependency>
    <groupId>com.jssolo</groupId>
    <artifactId>java-utils</artifactId>
    <version>${java-utils.version}</version>
</dependency>
```
## DateTools类中的方法
| 方法名 | 说明 | 返回内容 | 版本 |
|:---:|:---:|:---:|:---:|
| splitTime | 分割时间 | 返回分割后的时间集合，使用说明请移步[https://www.jssolo.com/java/9](https://www.jssolo.com/java/9) | 1.0.0 |
| dateAddDay | 对指定日期偏移指定的天数 | 处理后的日期 | 1.0.2 |
| dateAddHour | 对指定日期偏移指定的小时 | 处理后的时间 | 1.0.2 |
| firstIsBig | 判断时间大小 | 如果第一个时间大于第二个时间返回TRUE | 1.0.2 |
| firstIsBigAddHour | 判断时间大小 | 如果第一个时间大于第二个时间加偏移量返回TRUE | 1.0.2 |
| dateToString | Date类型转String类型 | 处理后的String对象 | 1.0.3 |
| stringToDate | String类型转Date类型 | 处理后的Date对象 | 1.0.3 |
| dateDiffMinutes | 计算两日期之间的分钟数 | 两日期之间的分钟数，采用四舍五入，可指定精确位数 | 1.0.4 |
| dateDiffHours | 计算两日期之间的小时数 | 两日期之间的小时差，采用四舍五入，可指定精确位数 | 1.0.4 |
| dateDiffDays | 计算两日期之间的天数 | 两日期之间的天数，采用四舍五入，可指定精确位数 | 1.0.4 |

## 问题反馈
邮件地址: solo@jssolo.cn
