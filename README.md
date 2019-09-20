# Neo4j Example with Spring Data Neo4j

## 保存/修改人员节点及人员与房产关系接口
 
 1. 接口：
  
```
  /person/save
 ```
  
  2. 入参示例：
  
 ```
{
    "id": "sss",
    "name": "Michael Wang",
    "gender": "男",
    "idCard": "3287188221110X",
    "houses": [
        {
            "name": "房产1",
            "location": "北京市1"
        },
        {
            "name": "房产2",
            "location": "北京市2"
        }
    ]
}
```

3. 返回结果示例：

```
{
    "msg": "success",
    "code": "200",
    "data": {
        "id": "sss",
        "name": "Michael Wang",
        "gender": "男",
        "idCard": "3287188221110X",
        "houses": [
            {
                "id": 186,
                "name": "房产1",
                "location": "北京市1"
            },
            {
                "id": 187,
                "name": "房产2",
                "location": "北京市2"
            }
        ]
    }
}
```
 
 
 ## 根据条件查询人员接口
 
1. 接口：
  
```
  /person/findByConditions
```

2. 入参示例：

```
{
    "name": "Michael Wang"
 }
```

3. 返回结果示例：

```
{
    "msg": "success",
    "code": "200",
    "data": {
        "id": "sss",
        "name": "Michael Wang",
        "gender": "男",
        "idCard": "3287188221110X",
        "houses": [
            {
                "id": 186,
                "name": "房产1",
                "location": "北京市1"
            },
            {
                "id": 187,
                "name": "房产2",
                "location": "北京市2"
            }
        ]
    }
}
```

## 动态增加节点属性示例

1. 接口：
  
```
  /graphNode/save
```

2. 入参示例：

```
{
    "id": "sss",
    "properties": {
        "name": "Michael Wang",
        "gender": "男",
        "idCard": "3287188221110X",
        "nation": "China"
    },
    "houses": [
        {
            "name": "房产1",
            "location": "北京市1"
        },
        {
            "name": "房产2",
            "location": "北京市2"
        }
    ]
}
```

3. 返回结果示例：

```
{
    "msg": "success",
    "code": "200",
    "data": {
        "id": "sss",
        "properties": {
            "name": "Michael Wang",
            "gender": "男",
            "idCard": "3287188221110X",
            "nation": "China"
        },
        "houses": [
            {
                "id": 242,
                "name": "房产1",
                "location": "北京市1"
            },
            {
                "id": 243,
                "name": "房产2",
                "location": "北京市2"
            }
        ]
    }
}
```