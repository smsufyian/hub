import com.pulumi.Context
import com.pulumi.Pulumi
import com.pulumi.gcp.organizations.Project
import com.pulumi.gcp.organizations.ProjectArgs

fun main() {
    Pulumi.run { ctx: Context ->
        val project = Project("my-gcp-project", ProjectArgs.builder()
            .projectId("my-gcp-project-id")
            .name("My GCP Project")
            .orgId("your-organization-id")  // Replace with your actual organization ID
            .billingAccount("your-billing-account")  // Replace with your actual billing account
            .build())

        ctx.export("projectId", project.id())
        ctx.export("projectNumber", project.number())
    }
}
