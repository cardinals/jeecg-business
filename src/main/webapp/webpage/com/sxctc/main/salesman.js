<!--首页banner系统数量-->

$(document).ready(function () {
    $.ajax({
        url: "tbMainController.do?getMainSystemNum",
        type: "post",
        data: {},
        dataType: "json",
        success: function (data) {

            var projectTotalNum = data.attributes.projectTotalNum;
            var notDockSystemNum = data.attributes.notDockSystemNum;
            var cloudDockSystemNum = data.attributes.cloudDockSystemNum;
            var researchFormSystemNum = data.attributes.researchFormSystemNum;
            var signPlanSystemNum = data.attributes.signPlanSystemNum;
            var allocatingResourcesSystemNum = data.attributes.allocatingResourcesSystemNum;
            var cloudTestSystemNum = data.attributes.cloudTestSystemNum;
            var recoveryAgreementSystemNum = data.attributes.recoveryAgreementSystemNum;
            var cloudCompleteNum = data.attributes.cloudCompleteNum;
            $("#projectTotalNum").html(projectTotalNum);
            $("#notDockSystemNum").html(notDockSystemNum);
            $("#cloudDockSystemNum").html(cloudDockSystemNum);
            $("#researchFormSystemNum").html(researchFormSystemNum);
            $("#signPlanSystemNum").html(signPlanSystemNum);
            $("#allocatingResourcesSystemNum").html(allocatingResourcesSystemNum);
            $("#cloudTestSystemNum").html(cloudTestSystemNum);
            $("#recoveryAgreementSystemNum").html(recoveryAgreementSystemNum);
            $("#cloudCompleteNum").html(cloudCompleteNum);

        }
    });
});
