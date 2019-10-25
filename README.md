# Neo4j Example with Spring Data Neo4j

For official use cases, see : [https://github.com/neo4j-examples](https://github.com/neo4j-examples);

主要实现了以下功能：

* 节点保存；
* 图谱查询；
* 最短路径查询；

主要解决的难点：

* 自定义主键，参考GraphNode、GraphNodeRepository类；
* 对复杂属性的保存，参考GraphNode的properties属性及传参示例中的nodes.properties；


保存方法传参示例：

```
{
  "nodes": [
    {
      "color": "#7076ed",
      "typeUri": "object.enterprise",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F0F7",
        "content": "",
        "font": "FontAwesome"
      },
      "x": -3.01189349204656,
      "active": false,
      "y": 0.18748324093041402,
      "label": "某公立医院",
      "id": "16560",
      "labelName": "单位",
      "properties": [
        {
          "propertyKey": "entName",
          "displayType": "C",
          "propertyName": "企业&#40;机构&#41;名称",
          "valueType": "string",
          "propertyValue": [
            "某公立医院"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "uniscId",
          "displayType": "C",
          "propertyName": "统一社会信用代码",
          "valueType": "string",
          "propertyValue": [
            "12370000495571840L"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "dataSourcesId",
          "displayType": "C",
          "propertyName": "数据来源ID",
          "valueType": "string",
          "propertyValue": [
            "4112"
          ],
          "detail": false,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "dataSources",
          "displayType": "C",
          "propertyName": "数据来源",
          "valueType": "string",
          "propertyValue": [
            "验证"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "updateTime",
          "displayType": "C",
          "propertyName": "最后更新时间",
          "valueType": "string",
          "propertyValue": [
            "2019-01-07 19:21:37"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        }
      ]
    },
    {
      "color": "#7076ed",
      "typeUri": "object.person",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F183",
        "content": "",
        "font": "FontAwesome"
      },
      "x": -1.0540001931243173,
      "active": false,
      "y": -0.9628764633767972,
      "label": "王某",
      "id": "20656",
      "labelName": "人员",
      "properties": [
        {
          "propertyKey": "name",
          "displayType": "C",
          "propertyName": "姓名",
          "valueType": "string",
          "propertyValue": [
            "王某"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "gender",
          "displayType": "C",
          "propertyName": "性别",
          "valueType": "string",
          "propertyValue": [
            "男"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "idNumber",
          "displayType": "C",
          "propertyName": "身份证号",
          "valueType": "string",
          "propertyValue": [
            "371205197406033995"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "birthday",
          "displayType": "C",
          "propertyName": "出生日期",
          "valueType": "string",
          "propertyValue": [
            "1974-06-03"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "nation",
          "displayType": "C",
          "propertyName": "民族",
          "valueType": "string",
          "propertyValue": [
            "汉族"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "nativePlace",
          "displayType": "C",
          "propertyName": "籍贯",
          "valueType": "string",
          "propertyValue": [
            "山东济南"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "marriageStatus",
          "displayType": "C",
          "propertyName": "婚姻状况",
          "valueType": "string",
          "propertyValue": [
            "已婚"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "workUnit",
          "displayType": "C",
          "propertyName": "工作单位",
          "valueType": "string",
          "propertyValue": [
            ""
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "familyAddress",
          "displayType": "C",
          "propertyName": "家庭住址",
          "valueType": "string",
          "propertyValue": [
            "山东省济南市历下区青龙后街163号"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "householdAddress",
          "displayType": "C",
          "propertyName": "户籍详址",
          "valueType": "string",
          "propertyValue": [
            "山东省济南市历下区青龙后街163号"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "dataSourcesId",
          "displayType": "C",
          "propertyName": "数据来源ID",
          "valueType": "string",
          "propertyValue": [
            "SDHJ"
          ],
          "detail": false,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "dataSources",
          "displayType": "C",
          "propertyName": "数据来源",
          "valueType": "string",
          "propertyValue": [
            "山东户籍信息"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "updateTime",
          "displayType": "C",
          "propertyName": "最后更新时间",
          "valueType": "string",
          "propertyValue": [
            "2019-01-08 08:53:00"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        }
      ]
    },
    {
      "color": "#7076ed",
      "typeUri": "object.person",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F183",
        "content": "",
        "font": "FontAwesome"
      },
      "x": 1.3371676714633272,
      "active": false,
      "y": -0.43201739664329786,
      "label": "张某",
      "id": "20680",
      "labelName": "人员",
      "properties": [
        {
          "propertyKey": "name",
          "displayType": "C",
          "propertyName": "姓名",
          "valueType": "string",
          "propertyValue": [
            "张某"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "gender",
          "displayType": "C",
          "propertyName": "性别",
          "valueType": "string",
          "propertyValue": [
            "男"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "idNumber",
          "displayType": "C",
          "propertyName": "身份证号",
          "valueType": "string",
          "propertyValue": [
            "441423199012229871"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "birthday",
          "displayType": "C",
          "propertyName": "出生日期",
          "valueType": "string",
          "propertyValue": [
            "1990年12月22日"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "nation",
          "displayType": "C",
          "propertyName": "民族",
          "valueType": "string",
          "propertyValue": [
            "汉族"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "nativePlace",
          "displayType": "C",
          "propertyName": "籍贯",
          "valueType": "string",
          "propertyValue": [
            ""
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "marriageStatus",
          "displayType": "C",
          "propertyName": "婚姻状况",
          "valueType": "string",
          "propertyValue": [
            "已婚"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "workUnit",
          "displayType": "C",
          "propertyName": "工作单位",
          "valueType": "string",
          "propertyValue": [
            ""
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "familyAddress",
          "displayType": "C",
          "propertyName": "家庭住址",
          "valueType": "string",
          "propertyValue": [
            ""
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "householdAddress",
          "displayType": "C",
          "propertyName": "户籍详址",
          "valueType": "string",
          "propertyValue": [
            ""
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "dataSourcesId",
          "displayType": "C",
          "propertyName": "数据来源ID",
          "valueType": "string",
          "propertyValue": [
            ""
          ],
          "detail": false,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "dataSources",
          "displayType": "C",
          "propertyName": "数据来源",
          "valueType": "string",
          "propertyValue": [
            ""
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "updateTime",
          "displayType": "C",
          "propertyName": "最后更新时间",
          "valueType": "string",
          "propertyValue": [
            "2018-12-27 14:28:30"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        }
      ]
    },
    {
      "color": "#7076ed",
      "typeUri": "object.tenderProject",
      "size": 1,
      "x": 0.2780591669794461,
      "active": false,
      "y": -3.7768466387279407,
      "label": "某医疗设备采购招标",
      "id": "16472",
      "labelName": "招标项目",
      "properties": [
        {
          "propertyKey": "tenderProjectCode",
          "displayType": "C",
          "propertyName": "招标编号",
          "valueType": "string",
          "propertyValue": [
            "93-ZC2018-1-442"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "tenderProjectName",
          "displayType": "C",
          "propertyName": "招标项目名称",
          "valueType": "string",
          "propertyValue": [
            "93-ZC2018-1-442"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "tenderContent",
          "displayType": "C",
          "propertyName": "招标内容及范围",
          "valueType": "string",
          "propertyValue": [
            "医疗设备的供货、安装、调试、验收、培训及售后服务等（详见招标文件附件6）。本项目采购预算为叁佰伍拾万圆整（￥3500000.00元），最高限价为：叁佰伍拾万圆整（￥3500000.00元）。"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "fundSource",
          "displayType": "C",
          "propertyName": "资金来源",
          "valueType": "string",
          "propertyValue": [
            "财政性资金"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "tenderType",
          "displayType": "C",
          "propertyName": "招标人单位性质",
          "valueType": "string",
          "propertyValue": [
            "事业法人"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "tendererCode",
          "displayType": "C",
          "propertyName": "招标人代码",
          "valueType": "string",
          "propertyValue": [
            "12370000495571840L"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "tenderName",
          "displayType": "C",
          "propertyName": "招标人名称",
          "valueType": "string",
          "propertyValue": [
            "某公立医院"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "buyerContact",
          "displayType": "C",
          "propertyName": "采购人联系人",
          "valueType": "string",
          "propertyValue": [
            "王某"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "buyerContactPhone",
          "displayType": "C",
          "propertyName": "采购人联系人电话",
          "valueType": "string",
          "propertyValue": [
            "15004214724"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        }
      ]
    },
    {
      "color": "#7076ed",
      "typeUri": "object.person",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F183",
        "content": "",
        "font": "FontAwesome"
      },
      "x": 1.6950243823135502,
      "active": false,
      "y": -1.5158120066468281,
      "label": "刘某",
      "id": "12312",
      "labelName": "人员",
      "properties": []
    },
    {
      "color": "#7076ed",
      "typeUri": "object.person",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F183",
        "content": "",
        "font": "FontAwesome"
      },
      "x": -3.8578412320658826,
      "active": false,
      "y": -2.0966711836090006,
      "label": "江某",
      "id": "24776",
      "labelName": "人员",
      "properties": []
    },
    {
      "color": "#7076ed",
      "typeUri": "object.house",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F015",
        "content": "",
        "font": "FontAwesome"
      },
      "x": 0.7764674007330923,
      "active": false,
      "y": 0.43246308219399815,
      "label": "万科城",
      "id": "12512",
      "labelName": "房产",
      "properties": []
    },
    {
      "color": "#7076ed",
      "typeUri": "object.car",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F1B9",
        "content": "",
        "font": "FontAwesome"
      },
      "x": -2.674904256396976,
      "active": false,
      "y": -3.4153550253382727,
      "label": "沃尔玛X60",
      "id": "28872",
      "labelName": "车辆",
      "properties": []
    },
    {
      "color": "#7076ed",
      "typeUri": "object.enterprise",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F0F7",
        "content": "",
        "font": "FontAwesome"
      },
      "x": 1.7473889407578027,
      "active": false,
      "y": -3.7096340696365706,
      "label": "振德医疗用品股份有限公司",
      "id": "24752",
      "labelName": "单位",
      "properties": []
    },
    {
      "color": "#7076ed",
      "typeUri": "object.tenderProject",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F05B",
        "content": "",
        "font": "FontAwesome"
      },
      "x": -4.227650435149265,
      "active": false,
      "y": 0.21468588460594484,
      "label": "某采购招投标1",
      "id": "8416",
      "labelName": "招标项目",
      "properties": []
    },
    {
      "color": "#7076ed",
      "typeUri": "object.person",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F183",
        "content": "",
        "font": "FontAwesome"
      },
      "x": 3.6445099352006713,
      "active": false,
      "y": -3.7582275612930456,
      "label": "武某",
      "id": "16408",
      "labelName": "人员",
      "properties": []
    },
    {
      "color": "#7076ed",
      "typeUri": "object.enterprise",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F0F7",
        "content": "",
        "font": "FontAwesome"
      },
      "x": -4.895493434782375,
      "active": true,
      "y": -0.5208333585314697,
      "label": "某药企",
      "id": "28848",
      "labelName": "单位",
      "properties": []
    },
    {
      "color": "#7076ed",
      "typeUri": "object.tenderProject",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F05B",
        "content": "",
        "font": "FontAwesome"
      },
      "x": -3.654220932975333,
      "active": false,
      "y": -0.787683546598325,
      "label": "某采购招投标2",
      "id": "32944",
      "labelName": "招标项目",
      "properties": []
    },
    {
      "color": "#7076ed",
      "typeUri": "object.enterprise",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F0F7",
        "content": "",
        "font": "FontAwesome"
      },
      "x": 2.987679299264021,
      "active": false,
      "y": -0.24469608235685958,
      "label": "顺庆医疗股份有限公司",
      "id": "33008",
      "labelName": "单位",
      "properties": []
    },
    {
      "color": "#7076ed",
      "typeUri": "object.person",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F183",
        "content": "",
        "font": "FontAwesome"
      },
      "x": -5.198812083724388,
      "active": false,
      "y": -2.736620695036441,
      "label": "张庆兵",
      "id": "192672",
      "labelName": "人员",
      "properties": [
        {
          "propertyKey": "name",
          "displayType": "C",
          "propertyName": "姓名",
          "valueType": "string",
          "propertyValue": [
            "张庆兵"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "idNumber",
          "displayType": "C",
          "propertyName": "身份证号",
          "valueType": "string",
          "propertyValue": [
            "371325198911243723"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        }
      ]
    },
    {
      "color": "#7076ed",
      "typeUri": "object.person",
      "size": 1,
      "icon": {
        "color": "#ebf1fc",
        "scale": 1.5,
        "contentStr": "F183",
        "content": "",
        "font": "FontAwesome"
      },
      "x": -5.226738831972545,
      "active": false,
      "y": -4.30724095800846,
      "label": "李彦宏",
      "id": "180432",
      "labelName": "人员",
      "properties": [
        {
          "propertyKey": "name",
          "displayType": "C",
          "propertyName": "姓名",
          "valueType": "string",
          "propertyValue": [
            "xingming"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "idNumber",
          "displayType": "C",
          "propertyName": "身份证号",
          "valueType": "string",
          "propertyValue": [
            "idcard"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "gender",
          "displayType": "C",
          "propertyName": "性别",
          "valueType": "string",
          "propertyValue": [
            "sex"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "nation",
          "displayType": "C",
          "propertyName": "民族",
          "valueType": "string",
          "propertyValue": [
            "nation"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "birthday",
          "displayType": "C",
          "propertyName": "出生日期",
          "valueType": "string",
          "propertyValue": [
            "birthday"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "marriageStatus",
          "displayType": "C",
          "propertyName": "婚姻状况",
          "valueType": "string",
          "propertyValue": [
            "married"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "nativePlace",
          "displayType": "C",
          "propertyName": "籍贯",
          "valueType": "string",
          "propertyValue": [
            "birthplace"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "householdAddress",
          "displayType": "C",
          "propertyName": "户籍详址",
          "valueType": "string",
          "propertyValue": [
            "huji"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "familyAddress",
          "displayType": "C",
          "propertyName": "家庭住址",
          "valueType": "string",
          "propertyValue": [
            "homeAddress"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        },
        {
          "propertyKey": "workUnit",
          "displayType": "C",
          "propertyName": "工作单位",
          "valueType": "string",
          "propertyValue": [
            "workplace"
          ],
          "detail": true,
          "queryType": "",
          "statistics": false
        }
      ]
    }
  ],
  "edges": [
    {
      "color": "#b956af",
      "size": 10,
      "typeUri": "FuYuanChang",
      "active": false,
      "highlight_color": "#b956af",
      "id": "custom-8fa8-9ea-7f24-87d8",
      "label": "副院长(1)",
      "source": "20656",
      "labelName": "副院长(1)",
      "type": "arrow",
      "properties": {
        "FuYuanChang": [
          {
            "sourceLabel": "object.person",
            "propertyList": [],
            "direct": "single",
            "targetLabel": "object.enterprise",
            "id": "custom-8fa8-9ea-7f24-87d8",
            "label": "FuYuanChang",
            "source": "20656",
            "category": "data.link.public",
            "labelName": "副院长",
            "linkName": "副院长",
            "target": "16560"
          }
        ]
      },
      "target": "16560"
    },
    {
      "color": "#b956af",
      "size": 10,
      "typeUri": "XingHui50Wan",
      "active": false,
      "highlight_color": "#b956af",
      "id": "custom-0ba5-fe0-24c4-b558",
      "label": "行贿50万(1)",
      "source": "20680",
      "labelName": "行贿50万(1)",
      "type": "arrow",
      "properties": {
        "XingHui50Wan": [
          {
            "sourceLabel": "object.person",
            "propertyList": [],
            "direct": "single",
            "targetLabel": "object.person",
            "id": "custom-0ba5-fe0-24c4-b558",
            "label": "XingHui50Wan",
            "source": "20680",
            "category": "data.link.public",
            "labelName": "行贿50万",
            "linkName": "行贿50万",
            "target": "20656"
          }
        ]
      },
      "target": "20656"
    },
    {
      "cc": {},
      "color": "#050ff6",
      "active": false,
      "highlight_color": "#050ff6",
      "label": "招标负责人(1)",
      "source": "16472",
      "type": "arrow",
      "target": "20656",
      "hover": false,
      "size": 10,
      "typeUri": "link.tender.leader",
      "id": "w0b-cpk-1hqt-fxs",
      "labelName": "招标负责人(1)",
      "properties": {
        "link.tender.leader": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "w0b-cpk-1hqt-fxs",
            "label": "link.tender.leader",
            "source": "16472",
            "labelName": "招标负责人",
            "linkName": "招标负责人",
            "target": "20656"
          }
        ]
      }
    },
    {
      "color": "#25ee12",
      "size": 10,
      "typeUri": "link.callRecords",
      "active": false,
      "highlight_color": "#25ee12",
      "id": "ydf-9i0-1fdh-fxs,yrn-9i0-1fdh-fxs,z5v-9i0-1fdh-fxs",
      "label": "通话(3)",
      "source": "12312",
      "labelName": "通话(3)",
      "type": "arrow",
      "properties": {
        "link.callRecords": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "ydf-9i0-1fdh-fxs",
            "label": "link.callRecords",
            "source": "12312",
            "labelName": "通话",
            "linkName": "通话",
            "target": "20656"
          },
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "z5v-9i0-1fdh-fxs",
            "label": "link.callRecords",
            "source": "12312",
            "labelName": "通话",
            "linkName": "通话",
            "target": "20656"
          },
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "yrn-9i0-1fdh-fxs",
            "label": "link.callRecords",
            "source": "12312",
            "labelName": "通话",
            "linkName": "通话",
            "target": "20656"
          }
        ]
      },
      "target": "20656"
    },
    {
      "cc": {
        "y": 2
      },
      "color": "#050ff6",
      "active": false,
      "highlight_color": "#050ff6",
      "label": "财务处处长(1)",
      "source": "16560",
      "type": "curvedArrow",
      "target": "20656",
      "hover": false,
      "size": 10,
      "typeUri": "link.enterprise.employee",
      "cc_prev_type": "arrow",
      "id": "134m-cs0-1kwl-fxs",
      "labelName": "财务处处长(1)",
      "properties": {
        "link.enterprise.employee": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "DA",
                "statistics": true
              },
              {
                "propertyKey": "post",
                "propertyName": "职务",
                "timeline": false,
                "propertyValue": "财务处处长",
                "statistics": true
              },
              {
                "propertyKey": "endDate",
                "propertyName": "任职截止",
                "timeline": true,
                "propertyValue": "",
                "statistics": false
              },
              {
                "propertyKey": "startDate",
                "propertyName": "任职起始",
                "timeline": true,
                "propertyValue": "2008-03-01",
                "statistics": false
              }
            ],
            "id": "134m-cs0-1kwl-fxs",
            "label": "link.enterprise.employee",
            "source": "16560",
            "labelName": "员工",
            "linkName": "财务处处长",
            "target": "20656"
          }
        ]
      }
    },
    {
      "cc": {
        "y": 3
      },
      "color": "#dcc4db",
      "active": false,
      "highlight_color": "#dcc4db",
      "label": "资金往来(2)",
      "source": "20656",
      "type": "curvedArrow",
      "target": "12312",
      "hover": false,
      "size": 10,
      "typeUri": "link.capitalExchange",
      "cc_prev_type": "arrow",
      "id": "1lp2-fxs-1el1-9i0,1m3a-fxs-1el1-9i0",
      "labelName": "资金往来(2)",
      "properties": {
        "link.capitalExchange": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1m3a-fxs-1el1-9i0",
            "label": "link.capitalExchange",
            "source": "20656",
            "labelName": "资金往来",
            "linkName": "资金往来",
            "target": "12312"
          },
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1lp2-fxs-1el1-9i0",
            "label": "link.capitalExchange",
            "source": "20656",
            "labelName": "资金往来",
            "linkName": "资金往来",
            "target": "12312"
          }
        ]
      }
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.car",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "1kwm-fxs-1k45-ma0",
      "label": "车辆(1)",
      "source": "20656",
      "labelName": "车辆(1)",
      "type": "arrow",
      "properties": {
        "link.car": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1kwm-fxs-1k45-ma0",
            "label": "link.car",
            "source": "20656",
            "labelName": "车辆",
            "linkName": "车辆",
            "target": "28872"
          }
        ]
      },
      "target": "28872"
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.relationship",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "13x2-fxs-1ij9-j48",
      "label": "夫妻关系(1)",
      "source": "20656",
      "labelName": "夫妻关系(1)",
      "type": "arrow",
      "properties": {
        "link.relationship": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "DA",
                "statistics": true
              },
              {
                "propertyKey": "relationShip",
                "propertyName": "关系类型",
                "timeline": false,
                "propertyValue": "夫妻关系",
                "statistics": true
              }
            ],
            "id": "13x2-fxs-1ij9-j48",
            "label": "link.relationship",
            "source": "20656",
            "labelName": "人员关系",
            "linkName": "夫妻关系",
            "target": "24776"
          }
        ]
      },
      "target": "24776"
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.house.property",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "1gk6-fxs-1jbp-9nk",
      "label": "房屋产权(1)",
      "source": "20656",
      "labelName": "房屋产权(1)",
      "type": "arrow",
      "properties": {
        "link.house.property": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1gk6-fxs-1jbp-9nk",
            "label": "link.house.property",
            "source": "20656",
            "labelName": "房屋产权",
            "linkName": "房屋产权",
            "target": "12512"
          }
        ]
      },
      "target": "12512"
    },
    {
      "cc": {
        "y": 1.5
      },
      "color": "#25ee12",
      "active": false,
      "highlight_color": "#25ee12",
      "label": "通话(3)",
      "source": "20656",
      "type": "curvedArrow",
      "target": "12312",
      "hover": false,
      "size": 10,
      "typeUri": "link.callRecords",
      "cc_prev_type": "arrow",
      "id": "1lau-fxs-1fdh-9i0,1us6-fxs-1fdh-9i0,1v6e-fxs-1fdh-9i0",
      "labelName": "通话(3)",
      "properties": {
        "link.callRecords": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1lau-fxs-1fdh-9i0",
            "label": "link.callRecords",
            "source": "20656",
            "labelName": "通话",
            "linkName": "通话",
            "target": "12312"
          },
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1v6e-fxs-1fdh-9i0",
            "label": "link.callRecords",
            "source": "20656",
            "labelName": "通话",
            "linkName": "通话",
            "target": "12312"
          },
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1us6-fxs-1fdh-9i0",
            "label": "link.callRecords",
            "source": "20656",
            "labelName": "通话",
            "linkName": "通话",
            "target": "12312"
          }
        ]
      }
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.tender.winningbidder",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "wsr-cpk-1gyd-j3k",
      "label": "中标单位(1)",
      "source": "16472",
      "labelName": "中标单位(1)",
      "type": "arrow",
      "properties": {
        "link.tender.winningbidder": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "wsr-cpk-1gyd-j3k",
            "label": "link.tender.winningbidder",
            "source": "16472",
            "labelName": "中标单位",
            "linkName": "中标单位",
            "target": "24752"
          }
        ]
      },
      "target": "24752"
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.tender.winningbidder",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "9i4-6hs-1gyd-m9c",
      "label": "中标单位(1)",
      "source": "8416",
      "labelName": "中标单位(1)",
      "type": "arrow",
      "properties": {
        "link.tender.winningbidder": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "9i4-6hs-1gyd-m9c",
            "label": "link.tender.winningbidder",
            "source": "8416",
            "labelName": "中标单位",
            "linkName": "中标单位",
            "target": "28848"
          }
        ]
      },
      "target": "28848"
    },
    {
      "cc": {},
      "color": "#25ee12",
      "active": false,
      "highlight_color": "#25ee12",
      "label": "通话(3)",
      "source": "16408",
      "type": "arrow",
      "target": "12312",
      "size": 10,
      "typeUri": "link.callRecords",
      "id": "114z-cns-1fdh-9i0,11j7-cns-1fdh-9i0,11xf-cns-1fdh-9i0",
      "labelName": "通话(3)",
      "properties": {
        "link.callRecords": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "11xf-cns-1fdh-9i0",
            "label": "link.callRecords",
            "source": "16408",
            "labelName": "通话",
            "linkName": "通话",
            "target": "12312"
          },
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "11j7-cns-1fdh-9i0",
            "label": "link.callRecords",
            "source": "16408",
            "labelName": "通话",
            "linkName": "通话",
            "target": "12312"
          },
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "114z-cns-1fdh-9i0",
            "label": "link.callRecords",
            "source": "16408",
            "labelName": "通话",
            "linkName": "通话",
            "target": "12312"
          }
        ]
      }
    },
    {
      "cc": {
        "y": 2
      },
      "color": "#dcc4db",
      "active": false,
      "highlight_color": "#dcc4db",
      "label": "资金往来(2)",
      "source": "16408",
      "type": "curvedArrow",
      "target": "12312",
      "hover": false,
      "size": 10,
      "typeUri": "link.capitalExchange",
      "cc_prev_type": "arrow",
      "id": "10cj-cns-1el1-9i0,10qr-cns-1el1-9i0",
      "labelName": "资金往来(2)",
      "properties": {
        "link.capitalExchange": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "10cj-cns-1el1-9i0",
            "label": "link.capitalExchange",
            "source": "16408",
            "labelName": "资金往来",
            "linkName": "资金往来",
            "target": "12312"
          },
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "10qr-cns-1el1-9i0",
            "label": "link.capitalExchange",
            "source": "16408",
            "labelName": "资金往来",
            "linkName": "资金往来",
            "target": "12312"
          }
        ]
      }
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.shareholder",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "16om-j3k-1mhh-cns",
      "label": "股东关系(1)",
      "source": "24752",
      "labelName": "股东关系(1)",
      "type": "arrow",
      "properties": {
        "link.shareholder": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "16om-j3k-1mhh-cns",
            "label": "link.shareholder",
            "source": "24752",
            "labelName": "股东关系",
            "linkName": "股东关系",
            "target": "16408"
          }
        ]
      },
      "target": "16408"
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.tender.section",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "1frq-cs0-1g5x-pf4",
      "label": "招标(1)",
      "source": "16560",
      "labelName": "招标(1)",
      "type": "arrow",
      "properties": {
        "link.tender.section": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1frq-cs0-1g5x-pf4",
            "label": "link.tender.section",
            "source": "16560",
            "labelName": "招标",
            "linkName": "招标",
            "target": "32944"
          }
        ]
      },
      "target": "32944"
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.tender.winningbidder",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "1g5y-pf4-1gyd-m9c",
      "label": "中标单位(1)",
      "source": "32944",
      "labelName": "中标单位(1)",
      "type": "arrow",
      "properties": {
        "link.tender.winningbidder": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1g5y-pf4-1gyd-m9c",
            "label": "link.tender.winningbidder",
            "source": "32944",
            "labelName": "中标单位",
            "linkName": "中标单位",
            "target": "28848"
          }
        ]
      },
      "target": "28848"
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.tender.section",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "1cly-cs0-1g5x-6hs",
      "label": "招标(1)",
      "source": "16560",
      "labelName": "招标(1)",
      "type": "arrow",
      "properties": {
        "link.tender.section": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1cly-cs0-1g5x-6hs",
            "label": "link.tender.section",
            "source": "16560",
            "labelName": "招标",
            "linkName": "招标",
            "target": "8416"
          }
        ]
      },
      "target": "8416"
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.enterprise.employee",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "1bti-m9c-1kwl-j48",
      "label": "副总经理(1)",
      "source": "28848",
      "labelName": "副总经理(1)",
      "type": "arrow",
      "properties": {
        "link.enterprise.employee": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "DA",
                "statistics": true
              },
              {
                "propertyKey": "post",
                "propertyName": "职务",
                "timeline": false,
                "propertyValue": "副总经理",
                "statistics": true
              },
              {
                "propertyKey": "endDate",
                "propertyName": "任职截止",
                "timeline": true,
                "propertyValue": "",
                "statistics": false
              },
              {
                "propertyKey": "startDate",
                "propertyName": "任职起始",
                "timeline": true,
                "propertyValue": "",
                "statistics": false
              }
            ],
            "id": "1bti-m9c-1kwl-j48",
            "label": "link.enterprise.employee",
            "source": "28848",
            "labelName": "员工",
            "linkName": "副总经理",
            "target": "24776"
          }
        ]
      },
      "target": "24776"
    },
    {
      "color": "#050ff6",
      "size": 10,
      "typeUri": "link.shareholder",
      "active": false,
      "highlight_color": "#050ff6",
      "id": "1sf2-pgw-1mhh-fyg",
      "label": "股东关系(1)",
      "source": "33008",
      "labelName": "股东关系(1)",
      "type": "arrow",
      "properties": {
        "link.shareholder": [
          {
            "propertyList": [
              {
                "propertyKey": "dataSourcesId",
                "propertyName": "数据来源ID",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              },
              {
                "propertyKey": "dataSourcesType",
                "propertyName": "数据来源类型",
                "timeline": false,
                "propertyValue": "",
                "statistics": true
              }
            ],
            "id": "1sf2-pgw-1mhh-fyg",
            "label": "link.shareholder",
            "source": "33008",
            "labelName": "股东关系",
            "linkName": "股东关系",
            "target": "20680"
          }
        ]
      },
      "target": "20680"
    }
  ]
}
```

 
 