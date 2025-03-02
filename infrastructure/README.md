# Infrastructure

This directory contains infrastructure-related code and configurations for the hub project.

## Purpose

The infrastructure directory is dedicated to housing all infrastructure-related code, including but not limited to:

- Infrastructure as Code (IaC) configurations
- Deployment scripts and templates
- Environment setup scripts
- Container configurations
- Cloud infrastructure definitions
- Infrastructure automation scripts

## Structure

The directory structure will be organized based on different infrastructure components and environments:

```
infrastructure/
├── README.md
├── environments/     # Environment-specific configurations
├── templates/       # Reusable infrastructure templates
└── scripts/        # Infrastructure management scripts
```

## Guidelines

- Keep infrastructure code separate from application code
- Document any environment-specific requirements
- Include clear instructions for infrastructure deployment
- Maintain version control for infrastructure changes

## Pulumi Infrastructure Setup

### Prerequisites

- [Pulumi CLI](https://www.pulumi.com/docs/get-started/install/)
- [Google Cloud SDK](https://cloud.google.com/sdk/docs/install)
- JDK 11 or later
- Kotlin 1.9.0 or later
- Google Cloud account with necessary permissions
- Google Cloud billing account

### Setup Instructions

1. Install the required tools:
   ```bash
   # Install Pulumi CLI
   curl -fsSL https://get.pulumi.com | sh

   # Install Google Cloud SDK
   # Follow instructions at https://cloud.google.com/sdk/docs/install
   ```

2. Configure Google Cloud credentials:
   ```bash
   # Login to Google Cloud
   gcloud auth application-default login

   # Set your project
   gcloud config set project YOUR_PROJECT_ID
   ```

3. Configure Pulumi:
   ```bash
   # Initialize Pulumi stack
   cd infrastructure
   pulumi stack init dev

   # Configure GCP project settings
   pulumi config set gcp:project YOUR_PROJECT_ID
   pulumi config set gcp:region YOUR_REGION
   pulumi config set gcp:organization YOUR_ORG_ID
   pulumi config set gcp:billingAccount YOUR_BILLING_ACCOUNT
   ```

### Usage

1. Update the project configuration in `src/main/kotlin/Main.kt` with your specific requirements.

2. Deploy the infrastructure:
   ```bash
   pulumi up
   ```

3. To destroy the infrastructure:
   ```bash
   pulumi destroy
   ```

### Resources Managed

- Google Cloud Project
- Additional resources will be added as needed

### Important Notes

- Replace placeholder values (YOUR_PROJECT_ID, YOUR_REGION, etc.) with your actual Google Cloud settings
- Keep your Google Cloud credentials secure and never commit them to version control
- Review the costs associated with the resources before deploying
